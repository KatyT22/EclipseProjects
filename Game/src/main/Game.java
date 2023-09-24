package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
La classe de jeu principale h�rite de la classe int�gr�e Canvas qui contient des fonctionnalit�s utiles pour cr�er le jeu, 
tels qu'une liste de touches qui relie les frappes au jeu et fonctionne pour cr�er la fen�tre de jeu. 
Le jeu impl�mente �galement Runnable qui permet de d�marrer et d'arr�ter des threads.
 */
public class Game extends Canvas implements Runnable {

    public static final int SQUARE = 64;                                                        //Divise le terrain de jeu en carr�s, chaque carr� est de 64 pixels
    public static final int FACTOR = 10;                                                        //Le terrain de jeu est de 10 carr�s de large
    public static final int WIDTH = SQUARE*FACTOR;                                              //La longueur du terrain de jeu est le nombre de carr�s*la longueur de chaque carr�
    public static final int HEIGHT = SQUARE*FACTOR;                                             //Samma h�jd som bredd
    public static final int SCALE = 1;                                                          //Scale om man vill f�rstora eller minska spelet proportionellt
    public final String TITLE = "Programme Java";                                              //Le nom du jeu

    private boolean running = false;                                                            //En boolean om tr�den ska k�ras eller ej
    private Thread thread;                                                                      //Skapar en ny tr�d

    //private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); //RedGreenBlue
    private BufferedImage background;

    //Skapa alla objekt som ska samverka med varandra
    private Player player;                                                                      //Skapar ett nytt objekt fr�n klassen Player
    private Wall wall;                                                                          //Skapar ett nytt objekt fr�n klassen Wall
    private Starter start;                                                                      //Skapar ett nytt objekt fr�n klassen Starter
    private Counter counter;                                                                    //Skapar ett nytt objekt fr�n klassen Counter

    public static enum STATE{                                                                   //Skapar tv� enum.
        GAME,                                                                                   //Game �r aktivt n�r spelet k�rs
        RESTART,                                                                                //Game �r aktivt n�r man v�ntar p� att starta spelet ("press enter to start")
    };
    public static STATE state = STATE.RESTART;                                                  //B�rja spelet med i l�get "press enter to start"

    public void init(){                                                                         //Skapar alla initialtillst�nd
        requestFocus();                                                                         //G�r s� att spelet �r aktivt n�r kompilatorn skapar spelplanen (�rvd fr�n Canvas)
        BufferedImageLoader loader = new BufferedImageLoader();                                 //Skapar en ny bildladdar-objekt
        try{
            background = loader.loadImage("background.png");                                   //F�rs�ker ladda in bakgrunden
        }
        catch (IOException e){                                                                  //Om fel intr�ffar, sl�ng ett felmeddelande
            e.printStackTrace();                                                                //Skriver ut felmeddelande
        }
        System.out.println("init !!!!");
        this.addKeyListener(new KeyInput(this));                                                //Kopplar tangenttryckningarna till spelet

        player = new Player(getWidth()/2-32,getHeight());                                       //Skapar ett nytt playerobjekt och ger koordinaterna till objektet
        wall = new Wall(0,0);                                                                   //Skapar ett nytt wallobjekt och ger koordinaterna till objektet
        counter = new Counter();                                                                //Skapar ett nytt objekt av typen Counter
        start = new Starter();                                                                  //Skapar ett nytt objekt av typen Starter
    }


    private synchronized void start(){                                                          //Metod f�r att starta tr�den (starta spelet)
        if(running){                                                                            //Om spelet redan �r startat, return (f�r att inte starta tr�den flera g�nger)
            return;
        }
        
        running = true;                                                                         //S�tter boolean running till true, spelet �r startat
        thread = new Thread(this);                                                              //Skapar en tr�d och kopplar spelet till tr�den
        System.out.println("start !!!!");
        thread.start();                                                                         //Starta tr�den
    }

    private synchronized void stop(){                                                           //Motsvarande som start fast f�r att st�nga tr�den
        if(!running) {                                                                          //K�r endast metoden om spelet �r ig�ng
            return;
        }
        System.out.println("stop !!!!");
        running = false;
        try {
            thread.join();                                                                      //Slutf�r tr�den
        }
        catch (InterruptedException e){                                                         //Om n�got f�r fel, kasta felmeddelande
            e.printStackTrace();
        }
        System.exit(1);                                                                         //St�nger ner spelet
    }



    public void run(){                                                                          //Metoden som k�rs n�r spelet �r ig�ng. Hanterar tick och render
        init();                                                                                 //Skapar alla objekten
        long lastTime = System.nanoTime();                                                      //Nuvarande tiden i nanosekunder sen
        final double amountOfTicks = 60.0;                                                      //Hastighet p� uppdateringarna
        double ns = 1000000000 / amountOfTicks;                                                 //Antal uppdateringar per sekund
        double delta = 0;                                                                       //Skillnad p� nuvarande tid och senaste uppdatering (tick)
        int updates = 0;                                                                        //Antal uppdateringar per sekund
        int frames = 0;
        long timer = System.currentTimeMillis();                                                //Antal millisekunder sen 1 Januari, 1970 (klassiskt startdatum i programmering)

        System.out.println("run !!!!");
        while(running){                                                                         //K�r spelet till spelet st�ngs av
            long now = System.nanoTime();                                                       //Nuvarande tid
            delta += (now - lastTime) / ns;                                                     //Ber�knar skillnaden
            lastTime = now;                                                                     //Nytt tidsteg
            if(delta >=1){                                                                      //Om antal steg �r st�rre �n 1, uppdatera
                tick();                                                                         //K�r metoden tick
                updates++;                                                                      //Uppdatera
                delta--;                                                                        //Nollst�ll Delta
            }
            render();                                                                           //Rita ut alla objekten
            frames++;                                                                           //R�kna hur m�nga frames som ritas ut

            //If-satsen beh�vs inte f�r spelet men ger mer f�rst�else �ver hur m�nga frames som skrivs ut
            if(System.currentTimeMillis() - timer > 1000){                                      //Skriv ut hur m�nga "frame per seconds" som har ritas ut
                timer += 1000;                                                                  //Uppdatera med en sekund
                //System.out.println(updates + " Ticks, Fps " + frames);                        //Skriv ut antal frames per sekund
                updates = 0;                                                                    //Nollst�ll
                frames = 0;
            }
        }
        stop();                                                                                 //Om spelet st�ngs av, st�ng av tr�den
    }

    private void tick(){                                                                        //K�rs varje uppdatering
        if(state==STATE.GAME) {                                                                 //Uppdatera bara om vi �r i "spell�ge"
            player.tick();                                                                      //Uppdatera player
            wall.tick();                                                                        //Uppdatera wall
            if(wall.collision(player.getBounds(player.getX(), player.getY()))){                 //Om player och wall kolliderar med varandra, �ndra spell�ge till "start-l�ge"
                state = STATE.RESTART;                                                          //�ndra till startl�ge
            }

        }
    }

    private void render(){                                                                      //Ritar ut objekten
        BufferStrategy bs = this.getBufferStrategy();                                           //BufferedStrategy g�r det m�jligt att ladda flera frames samtidigt, ger ett snabbare spel
        if (bs == null){
            createBufferStrategy(3);                                                            //Buffrar tre lager �t g�ngen
            return;
        }

        Graphics g = bs.getDrawGraphics();                                                      //G�r det m�jligt att rita ut objekten p� spelplanen
        g.drawImage(background, 0, 0, null);                                                    //Ritar ut bakgrunden


        if(state == STATE.GAME) {                                                               //Uppdatera bara om vi �r i "spell�ge"
            player.render(g);                                                                   //Rita ut objektet player
            wall.render(g);                                                                     //Rita ut objektet wall
            counter.render(g);                                                                  //Rita ut objektet counter

        }
        if(state == STATE.RESTART){                                                             //Om spelet �r i "start-l�ge"
            start.render(g);                                                                    //rita ut objektet starter

        }


        ////// ends here
        g.dispose();                                                                            //Uppdaterar f�reg�ende ritning
        bs.show();                                                                              //G�r alla objekt synliga
    }

    //F�ljande metoder g�r det m�jligt att hantera tangenttryck

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();                                                               //Nytt tangenttryck

        if(state == STATE.GAME) {                                                               //Piltangenterna fungerar bara n�r vi �r i "spel-l�ge"
            if (key == KeyEvent.VK_RIGHT) {                                                     //Om vi trycker h�ger, �ka hastigheten p� player �t h�ger
                player.setVelX(9);
            } else if (key == KeyEvent.VK_LEFT) {                                               //Om vi trycker v�nster, �ka hastigheten p� player �t v�nster
                player.setVelX(-9);
            } else if (key == KeyEvent.VK_DOWN) {                                               //Om vi trycker ner�t, �ka hastigheten p� player ner�t
                player.setVelY(9);
            } else if (key == KeyEvent.VK_UP) {                                                 //Om vi trycker upp, �ka hastigheten p� player upp�t
                player.setVelY(-9);
            }
        }
        else if (state == STATE.RESTART){                                                       //Om vi �r i "start-l�ge"
            if(key == KeyEvent.VK_ENTER){                                                       //Om vi trycker enter
                state = STATE.GAME;                                                             //�ndra till "spel-l�ge"
                player.setX(getWidth()/2-32);                                                   //S�tt ny x-koordinat p� player
                player.setY(getHeight());                                                       //S�tt ny y-koordinat p� player
                wall.y = 0;                                                                     //S�tt ny y-koordinat p� wall
                wall.setVelY(1);                                                                //S�tt starthastighet p� wall
                counter.reset();                                                                //Nollst�ll r�knaren
            }

        }
    }

    public void keyReleased(KeyEvent e){                                                        //N�r en tangent sl�pps
        int key = e.getKeyCode();                                                               //Ny tangent har sl�ppts


        if(key == KeyEvent.VK_RIGHT){                                                           //Om vi sl�pper h�gertangenten, s�tt hastigheten �t h�ger till noll
            player.setVelX(0);
        }
        else if(key == KeyEvent.VK_LEFT){                                                       //Om vi sl�pper v�nstertangenten, s�tt hastigheten �t v�nster till noll
            player.setVelX(0);
        }
        else if(key == KeyEvent.VK_DOWN){                                                       //Om vi sl�pper nertangenten, s�tt hastigheten ner�t till noll
            player.setVelY(0);
        }
        else if(key == KeyEvent.VK_UP){                                                         //Om vi sl�pper upptangenten, s�tt hastigheten upp�t till noll
            player.setVelY(0);
        }
    }


    //Mainmetoden - k�rs f�rst i programmet
    public static void main (String args[]){
        Game game = new Game();                                                                 //Skapar ett nytt game

        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));                    //Skapar dimensionerna f�r spelet enligt vad som �r angivet i klassvariablerna
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);                                                  // Skapar objektet frame och ger titeln p� spelet
        frame.add(game);                                                                        // Kopplar objektet game till GUI:t
        frame.pack();                                                                           //G�r GUI:t i r�tt storlek (samma storlek som spelet)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                   //Om man st�nger f�nstret, st�ng av programmet
        frame.setResizable(false);                                                              //G�r s� att man inte kan �ndra storlek p� f�nstret
        frame.setLocationRelativeTo(null);                                                      //Placerar GUI:t mitt p� sk�rmen
        frame.setVisible(true);                                                                 //G�r f�nstret synligt f�r anv�ndaren
        game.start();                                                                           //Starta spelet

    }
}



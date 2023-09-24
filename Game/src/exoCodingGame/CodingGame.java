package exoCodingGame;

public class CodingGame {

	public CodingGame() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String calc(int i) {

        String resultat = "";
/**** A compléter ici */
    
    int cent = (int) Math.floor(i/100); 
    i=i-(cent*100);

    int cinquante = (int) Math.floor(i/50);
    i=i-(cinquante*50);

    int vingt = (int) Math.floor(i/20);
    i=i-(vingt*20);

    int dix = (int) Math.floor(i/10);
    i=i-(dix*10);

    int deux = (int) Math.floor(i/2);
    i=i-(deux*2);

    int un = i;

    resultat = cent+" "+cinquante+" "+vingt+" "+dix+" "+deux+" "+un;

/***/
       return resultat;

}



public double calcSalaire
            (int nbHeures,
             int montantHoraire)
    {
        double salaire = 0;

       //TO COMPLETE
    
      

        if (nbHeures <= 160){
            salaire = montantHoraire * nbHeures;
        }
        else if(nbHeures > 160 && nbHeures <= 200){
    
            salaire = (montantHoraire * 160) + ((montantHoraire *1.25) * (nbHeures-160));
            
        }
        else if(nbHeures > 200){

            salaire = (montantHoraire * 160) + ((montantHoraire *1.25) * 40) + ((montantHoraire*1.50) * (nbHeures-200));
          
        }

        //
        return salaire;
    }

	
	 public String reverse(String s) {
	       char[] word = new char [s.length()];
	       for(int i=0; i<s.length(); i++){
	           word[i] = s.charAt(s.length()-(i+1));
	       }
	       String wordToString = new String(word);
	       return wordToString;

	 }

}

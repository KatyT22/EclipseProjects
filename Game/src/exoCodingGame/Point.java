package exoCodingGame;

public class Point {

    char nom;
    double value;

    public Point(char p, double v) {
        this.nom = p;
        this.value = v;
    }

    public String getNom() {
        
        return ""+nom;
    }

    public double getValue() {
        return value;
    }
}

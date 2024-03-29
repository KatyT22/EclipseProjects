package Templates;

public class Project {
	
	private float tauxInteret;
	private int nombreDeMensualite;
	private float montantInvesti;
	
	public Project(float tauxInteret, int nombreDeMensualite, float montantInvesti) {
		super();
		this.tauxInteret = tauxInteret;
		this.nombreDeMensualite = nombreDeMensualite;
		this.montantInvesti = montantInvesti;
	}
	
	public float getMontantInvesti() {
		return montantInvesti;
	}

	public void setMontantInvesti(float montantInvesti) {
		this.montantInvesti = montantInvesti;
	}

	public float getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(float tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public int getDureeDeRemboursementEnMois() {
		return nombreDeMensualite;
	}

	public void setNombreDeMensualite(int nombreDeMensualite) {
		this.nombreDeMensualite = nombreDeMensualite;
	}

	public float getRevenuParMensualite(){
		float interetParProjet = ((tauxInteret/100)*montantInvesti);
		return((montantInvesti+interetParProjet)/nombreDeMensualite);
	}
	
}

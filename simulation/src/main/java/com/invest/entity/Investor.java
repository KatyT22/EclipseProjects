package com.invest.entity;

public class Investor {

	private int capitalAInvestir;
	private Project[] projetEnCours;
	private Project[] projetArchive;

	public Investor(int capitalAInvestir) {
		super();
		this.capitalAInvestir = capitalAInvestir;
	}

	public int getCapitalAInvestir() {
		return capitalAInvestir;
	}

	public void setCapitalAInvestir(int capitalInvesti) {
		this.capitalAInvestir = capitalInvesti;
	}

	public Project[] getProjetEnCours() {
		return projetEnCours;
	}

	public void setProjetEnCours(Project[] projetEnCours) {
		this.projetEnCours = projetEnCours;
	}

	public Project[] getProjetArchive() {
		return projetArchive;
	}

	public void setProjetArchive(Project[] projetArchive) {
		this.projetArchive = projetArchive;
	}
	
	public void showGetCapitalAInvestir(){
		System.out.println("Capital investisseur = "+capitalAInvestir);
	}

	
}

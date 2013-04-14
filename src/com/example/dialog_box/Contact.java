package com.example.dialog_box;

public class Contact {
	
	private String _id, _nom, _prenom;

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getNom() {
		return _nom;
	}

	public void setNom(String nom) {
		_nom = nom;
	}

	public String getPrenom() {
		return _prenom;
	}

	public void setPrenom(String prenom) {
		_prenom = prenom;
	}

	public Contact(String id, String nom, String prenom) {
		super();
		_id = id;
		_nom = nom;
		_prenom = prenom;
	}

}

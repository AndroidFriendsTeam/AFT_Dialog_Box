package com.example.dialog_box;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<Contact> liste_Contact;
	String message,_idTemp;
	
	Integer _id,cpt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Contact contact1 = new Contact("ID1","Nom1","Prénom1");
		Contact contact2 = new Contact("ID2","Nom2","Prénom2");
		Contact contact3 = new Contact("ID3","Nom3","Prénom3");

		liste_Contact = new ArrayList<Contact>();
		liste_Contact.add(contact1);
		liste_Contact.add(contact2);
		liste_Contact.add(contact3);

		message = "";

		Button button_Dialog_Box = (Button) findViewById(R.id.buttonDialogBox);

		button_Dialog_Box.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();  
				HashMap<String, String> element;
				for(Contact c : liste_Contact){
					element = new HashMap<String, String>();
					element.put("id", c.getPrenom().toString());
					liste.add(element);
					
				}

				final ListAdapter adapter = new SimpleAdapter(MainActivity.this,
						liste,android.R.layout.simple_list_item_1,
						new String[]{"id"},
						new int[] {android.R.id.text1}
						);

				// Use the Builder class for convenient dialog construction
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder	.setTitle("Titre de la box")
						.setAdapter(adapter, new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								// The 'which' argument contains the index position of the selected item 	
								_id = which;
								cpt = 0;
//								Toast.makeText(getApplicationContext(), "Numéro de ligne sélectionné " + _id.toString(), Toast.LENGTH_SHORT).show();
								for(Contact c : liste_Contact){
//									Toast.makeText(getApplicationContext(), "ID du contact en cours : " + c.getId(), Toast.LENGTH_SHORT).show();
//									Toast.makeText(getApplicationContext(), "Numéro du compteur : " + cpt, Toast.LENGTH_SHORT).show();
									if(_id == cpt){
										Toast.makeText(getApplicationContext(), "Id du contact sélectionné : " + c.getId(), Toast.LENGTH_SHORT).show();
									}
									cpt += 1 ;
								}
							}
						})
						//Pas besoin de bouton OK
//						.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//							public void onClick(DialogInterface dialog, int id) {
//								Toast.makeText(getApplicationContext(), "Bouton ok", Toast.LENGTH_SHORT).show();
//							}
//						})
						//Pas besoin de bouton annulé 
//						.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//							public void onClick(DialogInterface dialog, int id) {
//								Toast.makeText(getApplicationContext(), "Bouton pas ok", Toast.LENGTH_SHORT).show();
//							}
//						})
						.create()
						.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

package com.javapapers.android.sqlitestorageoption;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ListActivity {
	Intent intent;
	TextView animalId;
	DBController controller = new DBController(this);
    DBExecute dbExecute = new DBExecute();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        dbExecute.saveAnimal();
		setContentView(R.layout.activity_main);
		ArrayList<HashMap<String, String>> animalList =  controller.getAllAnimals();
		if(animalList.size()!=0) {
			ListView lv = getListView();
			lv.setOnItemClickListener(new OnItemClickListener() {
				  @Override 
				  public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
					  animalId = (TextView) view.findViewById(R.id.animalId);
					  String valAnimalId = animalId.getText().toString();
					  Intent  objIndent = new Intent(getApplicationContext(),EditAnimal.class);
					  objIndent.putExtra("animalId", valAnimalId); 
					  startActivity(objIndent); 
				  }
			}); 
			ListAdapter adapter = new SimpleAdapter( MainActivity.this,animalList, R.layout.view_animal_entry, new String[] { "animalId","animalName"}, new int[] {R.id.animalId, R.id.animalName}); 
			setListAdapter(adapter);
		}
	}
	public void showAddForm(View view) {
		Intent objIntent = new Intent(getApplicationContext(), NewAnimal.class);
		startActivity(objIntent);
	}
}

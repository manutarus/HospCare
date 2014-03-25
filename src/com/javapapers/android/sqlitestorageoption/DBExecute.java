package com.javapapers.android.sqlitestorageoption;

import android.app.Activity;

import java.util.HashMap;

/**
 * User: manu
 * Date: 3/25/14
 * Time: 9:47 PM
 */
public class DBExecute extends Activity {
    DBController controller = new DBController(this);

    public void saveAnimal(){
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        queryValues.put("animalName", "hit");
        controller.insertAnimal(queryValues);

    }
}

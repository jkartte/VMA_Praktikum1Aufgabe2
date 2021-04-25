package de.thkoeln.cvogt.android.activities;

//LogCat beim Drücken des Back-Buttons in Activity2:
//04-25 11:07:52.077 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO:       ---> Activity2: onPause() <---
//04-25 11:07:52.081 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO: ---> Activity1: onStart() <---
//04-25 11:07:52.081 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO: ---> Activity1: onResume() <---
//04-25 11:07:52.423 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO:       ---> Activity2: onStop() <---
//04-25 11:07:52.423 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO:       ---> Activity2: onDestroy() <---
//Der LogCat zeigt keinen Eintrag für die Methode onSaveInstanceState(). Die Methode müsste eigentlich nach dem
//Pausieren von Activity 2 ausgeführt werden und an dieser Stelle im LogCat vermerkt werden, anscheinend ist
//das hier aber nicht passiert.


// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 4.12.2015

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    private String text;
    private EditText editText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState!=null)
            text=savedInstanceState.getString("StringKey");

        editText = (EditText) findViewById(R.id.plain_text_input);

        //Überprüfen, ob die Eingabe in der Variable text gespeichert wurde:
        final TextView textView = (TextView) findViewById(R.id.displayEditText);

        //TextWatcher ermöglicht das Ausführen von Methoden, bevor/während/nachdem
        //das editText-Feld geändert wurde.
        editText.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){};
            @Override
            public void afterTextChanged(Editable s) {};
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = editText.getText().toString(); //sobald das EditText-Feld geändert wird, wird die Eingabe gespeichert
                textView.setText(text);
            };
        });

        Toast.makeText(this,"Activity 2: onCreate()", Toast.LENGTH_LONG).show();
        
        Log.v("DEMO","      ---> Activity2: onCreate() <--- ");
    }

    public void onStart() {
        super.onStart();
        Log.v("DEMO","      ---> Activity2: onStart() <--- ");
    }        

    public void onResume() {
        super.onResume();
        Log.v("DEMO","      ---> Activity2: onResume() <--- ");
    }        

    public void onPause() {
        super.onPause();
        Log.v("DEMO","      ---> Activity2: onPause() <--- ");
    }        

    public void onStop() {
        super.onStop();
        Log.v("DEMO","      ---> Activity2: onStop() <--- ");
    }        

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","      ---> Activity2: onDestroy() <--- ");
    }


    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("StringKey",text);
        Log.v("DEMO","      ---> Activity2: onSaveInstanceState() <--");
    }

}



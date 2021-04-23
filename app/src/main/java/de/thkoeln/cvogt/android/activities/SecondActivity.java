package de.thkoeln.cvogt.android.activities;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 4.12.2015

// Eine App mit zwei Activities, zwischen denen man hin- und herschalten kann.
// LogCat-Ausgaben zeigen dabei an, wann welche Zustandsübergangsmethoden (Callbacks) ausgeführt werden.
// Video dazu: https://youtu.be/Zwswz3UmvOc

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/* Diese zweite Aktivität muss ggf. per Hand im Manifest eingetragen werden.
   Sie wird dort automatisch eingetragen, wenn im Project-Unterfenster auf 'java'
   rechts-klickt und dann den Menus "New > Activity > ..." folgt. */

public class SecondActivity extends Activity {

    private String text;
    private EditText editText;

    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = (EditText) findViewById(R.id.plain_text_input);
        String text = editText.getText().toString();

        Toast.makeText(this,"Activity 2: onCreate()", Toast.LENGTH_LONG).show();
        
        Log.v("DEMO","      ---> Activity2: onCreate() <--- ");
        // Log.v("DEMO","Activity2: Intent.getComponent() = "+getIntent().getComponent());

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
        Log.v("PRAKTIKUM","---> onSaveInstanceState() <--");
    }

}



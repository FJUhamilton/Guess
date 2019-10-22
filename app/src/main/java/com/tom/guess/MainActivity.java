package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edNumber;
    TextView name;
    TextView texttime;
    ImageView smile;
    Button guess;
    int a =1;
    Random random=new Random();
    int secret=(int)(Math.random()*10+1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edNumber = findViewById(R.id.editText);
        name = findViewById(R.id.name);
        smile = findViewById(R.id.goodjob);
        texttime = findViewById(R.id.texttime);
        guess = findViewById(R.id.guess);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void guess(View view){

        int number = Integer.parseInt(edNumber.getText().toString());

        if(number<secret){
            name.setText("Bigger. Not "+number);
            texttime.setText("You guessed  "+a+" times.");
            a = a+1;
        }else if (number>secret){
            name.setText("Smaller.Not "+ number);
            texttime.setText("You guessed  "+a+" times.");
            a = a+1;
        }else{
            name.setText("Good.You got it.The secret number is "+secret);
            texttime.setText("You guessed  "+a+" times.");
            smile.setVisibility(View.VISIBLE);
            guess.setVisibility(View.INVISIBLE);
        }

    }

    public void restart (View view){
        secret=(int)(Math.random()*10+1);
        name.setText("Guess 1~10");
        texttime.setText("");
        guess.setVisibility(View.VISIBLE);
        smile.setVisibility(View.INVISIBLE);
        a=a-a;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

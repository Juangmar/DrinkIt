package koldur.losversados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button lightButton;
        Button medButton;
        Button highButton;
        Button allButton;
        Button yoNuncaButton;
        Button dedoAcusadorButton;

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        medButton = (Button)findViewById(R.id.buttonMed);
        medButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente8 = new Intent(MainActivity.this, MedActivity.class);
                startActivity(siguiente8);
            }
        });

        lightButton = (Button)findViewById(R.id.buttonLight);
        lightButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente7 = new Intent(MainActivity.this, LowActivity.class);
                startActivity(siguiente7);
            }
        });

        highButton = (Button)findViewById(R.id.buttonHigh);
        highButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente9 = new Intent(MainActivity.this, HighActivity.class);
                startActivity(siguiente9);
            }
        });

        allButton = (Button)findViewById(R.id.todosLosVR);
        allButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente10 = new Intent(MainActivity.this, AllVRActivity.class);
                startActivity(siguiente10);
            }
        });

        yoNuncaButton = (Button)findViewById(R.id.buttonYoNunca);
        yoNuncaButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente11 = new Intent(MainActivity.this, ynActivity.class);
                startActivity(siguiente11);
            }
        });

        dedoAcusadorButton = (Button) findViewById(R.id.elDedoAcusador);
        dedoAcusadorButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente11 = new Intent(MainActivity.this, daActivity.class);
                startActivity(siguiente11);
            }
        });
    }
}

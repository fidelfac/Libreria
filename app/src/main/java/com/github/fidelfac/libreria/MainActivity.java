package com.github.fidelfac.libreria;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.fidelfac.libreriaintroduccion.Introduccion1;


public class MainActivity extends Activity {

    private Introduccion1 intro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        intro = (Introduccion1) findViewById(R.id.view);

        Intent intent = new Intent(this, MainActivity2.class);



    }
}

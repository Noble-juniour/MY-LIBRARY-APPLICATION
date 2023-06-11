package com.example.library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnALLBOOKS,btnCURRENT,btnWantTO,btnALREADY,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.in,R.anim.out);


        initWidgets();
        SetOnclickListeners();
    }

    private void SetOnclickListeners()
    {
        btnALLBOOKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
        btnALREADY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadActivity.class);
                startActivity(intent);
            }
        });
        btnWantTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadActivity.class);
                startActivity(intent);
            }
        });
        btnCURRENT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });
    }
    private void aboutTapped()
    {
        Log.d(TAG, "aboutTapped: started");

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("About My Library App")
                .setMessage("Builder and published by Kevin Indangasi.\n" +
                        "\n" +
                        "If you want to hire me or \n" +
                        "if you want to  check my other works\n" +
                        "email or whatsapp kevinindangasi1@gmail.com and 0743827630")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainActivity.this, MyWebViewActivity.class);
                                intent.putExtra("url","https://mail.google.com/");
                                startActivity(intent);
                            }
                        })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
        builder.create().show();
    }
    private void initWidgets()
    {
        btnALLBOOKS = (Button)  findViewById(R.id.btnALLBOOKS);
        btnCURRENT  = (Button)  findViewById(R.id.btnCURRENT);
        btnWantTO   = (Button)  findViewById(R.id.btnWantTO);
        btnALREADY  = (Button)  findViewById(R.id.btnALREADY);
        btnAbout    = (Button)  findViewById(R.id.btnAbout);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
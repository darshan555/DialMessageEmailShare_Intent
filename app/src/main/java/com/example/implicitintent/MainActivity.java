package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDial,btnMsg,btnEmail,btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.dialBTN);
        btnMsg = findViewById(R.id.msgBTN);
        btnEmail = findViewById(R.id.emailBTN);
        btnShare = findViewById(R.id.shareBTN);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +918526574895"));
                startActivity(iDial);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+918574789685")));
                iMsg.putExtra("sms_body","This is problem,please solve it.");
                startActivity(iMsg);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMail = new Intent(Intent.ACTION_SEND);
                iMail.setType("message/rfc822");
                iMail.putExtra(Intent.EXTRA_EMAIL,new String[]{"dmb38600@gmail.com"});
                iMail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iMail.putExtra(Intent.EXTRA_TEXT,"Please solve this problem");
                startActivity(Intent.createChooser(iMail,"Email via"));
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Download this app , https://play.google.com/store/apps/details?id=com.appsomniacs.da2&hl=en_IN&gl=US");
                startActivity(Intent.createChooser(iShare,"Share via"));
            }
        });

    }
}
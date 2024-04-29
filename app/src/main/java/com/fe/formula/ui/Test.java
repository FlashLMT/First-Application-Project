package com.fe.formula.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.fe.formula.R;

public class Test extends AppCompatActivity {

    ImageView fb, gm, git;
    Intent intent = null, chooser = null;
    Button tex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ImageView fb = (ImageView) findViewById(R.id.fbb);
        ImageView git = (ImageView) findViewById(R.id.github);
        ImageView gm = (ImageView) findViewById(R.id.gmail);
        Button tex = (Button) findViewById(R.id.cont);
      /*  tex.setOnClickListener((View.OnClickListener) this);
        tex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test.this, "this is Count", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
    /*    git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Test.this, "This is Github", Toast.LENGTH_SHORT).show();

            }
        });

        gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("Hello:"));
                String[] to = {"lwinminthant917@gmail.com"};
                intent.putExtra(intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "First Email");
                intent.putExtra(Intent.EXTRA_TEXT, "Hey Lwin.What are you doing");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Send Email");
                startActivity(chooser);

            }
        });*/


    }

}
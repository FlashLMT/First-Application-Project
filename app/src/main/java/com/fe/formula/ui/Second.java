package com.fe.formula.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fe.formula.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class Second extends AppCompatActivity {
    TextView tvv, tvvv;
    ImageView img;
    String imgg;
 private Toolbar tb;
 CollapsingToolbarLayout collapsingToolbarLayout;
    private Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar tb=findViewById(R.id.tool);

        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvv = (TextView) findViewById(R.id.title_b);
        ImageView img = (ImageView) findViewById(R.id.imageView2);
        TextView tvvv = findViewById(R.id.textView2);
        tvvv.setText((Objects.requireNonNull(getIntent().getExtras()).getString("description")));
        tvv.setText((Objects.requireNonNull(getIntent().getExtras()).getString("title")));
         imgg=getIntent().getStringExtra("image");
        Glide.with(this).load(getIntent().getStringExtra("image"))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(img);

    }

}

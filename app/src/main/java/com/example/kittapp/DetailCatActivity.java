package com.example.kittapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailCatActivity extends AppCompatActivity {

    TextView txtName,txtDescription;
    ImageView imgCat;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cat);

        //initial view
        txtName = findViewById(R.id.txt_detail_name_cat);
        txtDescription = findViewById(R.id.txt_detail_description);
        imgCat = findViewById(R.id.image_detail_cat);

        //get data from intent
        byte[] bytes = getIntent().getByteArrayExtra("image");
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("description");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        //set data to views
        txtName.setText(name);
        txtDescription.setText(desc);
        imgCat.setImageBitmap(bmp);

        //get image from imageview as bitmap
        bitmap = ((BitmapDrawable)imgCat.getDrawable()).getBitmap();

    }
}

package com.example.testapp_applab.Voorbeelden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp_applab.R;

public class Aminozuren2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aminozuren2);

        String name = getIntent().getStringExtra("NAME");
        String abbrBig = getIntent().getStringExtra("ABBR_BIG");
        String abbrSmall = getIntent().getStringExtra( "ABBR_SMALL");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView nameTextView = findViewById(R.id.AATitle);
        TextView AA3LetterTextView = findViewById(R.id.AA_Tile_3_Letters);
        TextView AA1LetterTextView = findViewById(R.id.AA_Title_1_Letter);
        TextView descriptionTextView = findViewById(R.id.AA_Description);
        ImageView AA_Image = findViewById(R.id.AA_Image);

        nameTextView.setText(name);
        AA3LetterTextView.setText(abbrBig);
        AA1LetterTextView.setText(abbrSmall);
        descriptionTextView.setText(description);
        AA_Image.setImageResource((image));
    }
}
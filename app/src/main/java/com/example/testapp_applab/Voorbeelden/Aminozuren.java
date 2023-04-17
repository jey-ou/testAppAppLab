package com.example.testapp_applab.Voorbeelden;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.AminoAcidModel;

import java.util.ArrayList;

public class Aminozuren extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<AminoAcidModel> aminoAcidModels = new ArrayList<>();
    int[] aminoAcidImages = {R.drawable.ic_alanine, R.drawable.ic_arginine, R.drawable.ic_asparagine,
            R.drawable.ic_aspartic_acid, R.drawable.ic_cysteine, R.drawable.ic_pyrrolysine,
            R.drawable.ic_glutamine, R.drawable.ic_glutamic_acid, R.drawable.ic_glycine,
            R.drawable.ic_histidine, R.drawable.ic_lsoleucine ,R.drawable.ic_leucine,
            R.drawable.ic_lysine, R.drawable.ic_methionine, R.drawable.ic_phenylalanine,
            R.drawable.ic_pyrrolysine,R.drawable.ic_serine, R.drawable.ic_threonine,
            R.drawable.ic_tryptophan, R.drawable.ic_tyrosine, R.drawable.ic_tryptophan,
            R.drawable.ic_valine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aminozuren);

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        setUpAminoAcidModels();

        AA_RecyclerViewAdapter adapter = new AA_RecyclerViewAdapter(this, aminoAcidModels, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpAminoAcidModels(){
        String[] aminoAcidNames = getResources().getStringArray(R.array.amino_acids_full_text);
        String[] aminoAcidAbreviations = getResources().getStringArray(R.array.amino_acids_one_letter_txt);
        String[] aminoAcidAbreviationSmall = getResources().getStringArray(R.array.amino_acids_three_letter_txt);

        for(int i = 0; i<aminoAcidNames.length; i++){
            aminoAcidModels.add(new AminoAcidModel(aminoAcidNames[i],
                    aminoAcidAbreviations[i],
                    aminoAcidAbreviationSmall[i],
                    aminoAcidImages[i]) );
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}
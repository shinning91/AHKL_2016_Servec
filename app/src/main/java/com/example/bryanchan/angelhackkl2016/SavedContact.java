package com.example.bryanchan.angelhackkl2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by bryanchan on 05/06/2016.
 */
public class SavedContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedcontact);
    }

    public void goProfile(View view) {
        Intent peopleProf = new Intent(this, PeopleProfile.class);
        boolean saved = true;
        peopleProf.putExtra("num", saved);
        startActivity(peopleProf);
    }
}
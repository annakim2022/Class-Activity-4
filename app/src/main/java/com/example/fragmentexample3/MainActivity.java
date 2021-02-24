package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we can find the second fragment in the layout
        // that means we have 2 panes -> landscape
        if (findViewById(R.id.fragContainer_land_second) != null){
            twoPane = true;
        }
        // loading in either 1 or 2 frags based on this boolean variable
        if (!twoPane){ // port
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button button = findViewById(R.id.button_personality);
            Button button2 = findViewById(R.id.button_houseInfo);
            button.setOnClickListener(v -> launchActivity(v, false));
            button2.setOnClickListener(v -> launchActivity(v, true));
        }
        else {
            loadFragment(new FirstFragment(), R.id.fragContainer_land_first);
            loadFragment(new SecondFragment(), R.id.fragContainer_land_second);
            loadFragment(new ThirdFragment(), R.id.fragContainer_land_third);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainerView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view, boolean button){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("button", button);
        startActivity(intent);
    }
}
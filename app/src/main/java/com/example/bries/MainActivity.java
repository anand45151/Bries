package com.example.bries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.bries.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFrag(new  Home());
        binding.bnView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){
                case R.id.home:
                    replaceFrag(new Home());
                    break;
                case R.id.track:
                    replaceFrag(new Track());
                    break;
                case R.id.order:
                    replaceFrag(new Order());
                    break;

                case R.id.fav:
                    replaceFrag(new Favourite());
                    break;

                case R.id.profile:
                    replaceFrag(new Profile());
                    break;
            }
            return true;
        });

    }
    public void replaceFrag(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameCon,fragment);
        fragmentTransaction.commit();

    }
    }

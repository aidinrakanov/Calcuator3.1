package com.example.calcuator31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.pm.ActivityInfo;

public class MainActivity extends AppCompatActivity {

    ShareFragment shareFragment;
    String text;
    Button calc;
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = findViewById(R.id.CalcFrag);
        share = findViewById(R.id.ShareFrag);
    }


    public void FragmentManager(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

    public void openCalc() {
        FragmentManager(new FragmentCalculator());
    }

    public void openShare() {
        if (text == null) {
            FragmentManager(new ShareFragment());
        } else if (text != null) {
            shareFragment = new ShareFragment();
            Bundle bundle = new Bundle();
            bundle.putString("result", text);

            shareFragment.setArguments(bundle);
            FragmentManager(shareFragment);
        }
    }

    public void sendNumber(String number) {
        text = number;
    }

    public void frg_btn(View view) {

        switch (view.getId()){
            case R.id.CalcFrag:
            openCalc();
            break;
            case R.id.ShareFrag:
            openShare();
            break;
        }
    }
}

package com.example.calcuator31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Share extends AppCompatActivity {
    TextView res;
    String savedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        res=findViewById(R.id.result2);
        if (savedInstanceState != null){
            savedString = savedInstanceState.getString("savedString");
            res.setText(savedString);
            Log.d("ololo","onCreate"+ savedString);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo","onStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo","onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedString", res.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo","onDestroy");
    }

    public void toCalculator(View view) {
        Intent intent = new Intent(Share.this, MainActivity.class);
        startActivityForResult(intent,11);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==11 && resultCode == RESULT_OK){
            String result = data.getStringExtra("resultat");
            res.setText(result);
        }
    }

    public void shareToTelegram(View view) {

    }
}

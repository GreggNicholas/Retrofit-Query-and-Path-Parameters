package com.example.retrofitqueryandpathparameters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText;
        final Button button;

        editText = findViewById(R.id.edittext_main);
        button = findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNumInput = editText.getText().toString();

                ResultFragment resultFragment = ResultFragment.getInstance(getNumInput);


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragcontainer_main, resultFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

    }


}

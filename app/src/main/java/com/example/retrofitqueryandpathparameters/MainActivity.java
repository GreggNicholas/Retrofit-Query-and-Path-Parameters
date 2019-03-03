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
    private static final String TAG = "MainActivity";
    private EditText editText;

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
                retrofitCall();
            }
        });

    }

    public void retrofitCall() {
        String userInput = editText.getText().toString();
        final Retrofit retrofit = RetrofitSingleton.newInstance();
        NumbersService numberService = retrofit.create(NumbersService.class);
        Call<NumberModel> getNumberCall = numberService.getNumbers(userInput);
        getNumberCall.enqueue(new Callback<NumberModel>() {
            @Override
            public void onResponse(Call<NumberModel> call, Response<NumberModel> response) {
                Log.d(TAG, "onResponse: " + response.body().getText());
            }

            @Override
            public void onFailure(Call<NumberModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }


}

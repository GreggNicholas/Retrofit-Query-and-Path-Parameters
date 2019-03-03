package com.example.retrofitqueryandpathparameters;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private static final String TAG = "ResultFragment";
    private EditText editText;

    public ResultFragment() {
    }

    public static ResultFragment getInstance() {
        ResultFragment resultFragment = new ResultFragment();

        return resultFragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
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

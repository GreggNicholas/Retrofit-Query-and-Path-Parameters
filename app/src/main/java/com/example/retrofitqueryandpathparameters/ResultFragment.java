package com.example.retrofitqueryandpathparameters;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private static final String TAG = "ResultFragment";
    private static final String NUM_KEY = "Params1";
    private static String userNumInput;

    public ResultFragment() {
    }

    public static ResultFragment getInstance() {
        ResultFragment resultFragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString(NUM_KEY, userNumInput);
        return resultFragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(getArguments() != null){
            userNumInput = getArguments().getString(NUM_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView userInputTextView = view.findViewById(R.id.textview_resultfrag);
        final Retrofit retrofit = RetrofitSingleton.newInstance();
        NumbersService numberService = retrofit.create(NumbersService.class);
        Call<NumberModel> getNumberCall = numberService.getNumbers(userNumInput);
        getNumberCall.enqueue(new Callback<NumberModel>() {
            @Override
            public void onResponse(Call<NumberModel> call, Response<NumberModel> response) {
                Log.d(TAG, "onResponse: " + response.body().getNumberFacts());
                userInputTextView.setText(response.body().getNumberFacts());
            }

            @Override
            public void onFailure(Call<NumberModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

}


package com.example.android.fragmentassignment102;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by CHANDAN on 6/15/2017.
 */

public class DetailFragment extends Fragment {
    public static String KEY_LAYOUTS_NUMBER = "KEY_LAYOUTS_NUMBER";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null &&
                bundle.containsKey(KEY_LAYOUTS_NUMBER)){
            showSelectedLayout(bundle.getString(KEY_LAYOUTS_NUMBER));
        }
    }

    //to update the TextView when we receive the selected layout name
    public void showSelectedLayout(String layoutNumber){
        ((TextView)getView().findViewById(R.id.textViewLayoutNumber)).setText(layoutNumber);
    }
}

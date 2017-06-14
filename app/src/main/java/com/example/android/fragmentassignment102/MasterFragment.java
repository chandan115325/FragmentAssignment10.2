package com.example.android.fragmentassignment102;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CHANDAN on 6/15/2017.
 */

public class MasterFragment extends ListFragment {
    //creating the interface to communicate with other fragments and main activity
    public interface OnMasterSelectedListener {
        public void onItemSelected(String layoutNumber);
    }

    //setting up the interface callback listener
    private OnMasterSelectedListener
            mOnMasterSelectedListener = null;
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener){
        mOnMasterSelectedListener = listener;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        String[] layoutItems = new String[]{"Layout1", "Layout2", "Layout3", "Layout4","Layout5",
                "Layout6","Layout7"};
        ListAdapter countryAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,layoutItems);
        setListAdapter(countryAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mOnMasterSelectedListener != null){
                    mOnMasterSelectedListener.onItemSelected(((TextView)view).getText().toString());
                }
            }
        });

    }
}

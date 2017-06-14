package com.example.android.fragmentassignment102;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class ListActivity extends AppCompatActivity {
    boolean dualPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MasterFragment masterFragment = null;
        FrameLayout frameLayout =
                (FrameLayout)findViewById(R.id.frameLayout);
        if(frameLayout != null) {
            dualPane = false;
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            masterFragment = (MasterFragment) getSupportFragmentManager()
                    .findFragmentByTag("MASTER");

            if (masterFragment == null) {
                masterFragment = new MasterFragment();
                fragmentTransaction.add(R.id.frameLayout,
                        masterFragment, "MASTER");
            }
            DetailFragment detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(
                            R.id.frameLayoutDetail);
            if (detailFragment != null) {
                fragmentTransaction.remove(detailFragment);
            }
            fragmentTransaction.commit();
        }
        else {
            dualPane = true;
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            masterFragment = (MasterFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutMaster);

            if (masterFragment == null) {
                masterFragment = new MasterFragment();
                fragmentTransaction.add(R.id.frameLayoutMaster, masterFragment);

            }

            DetailFragment detailFragmenta = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);
            if (detailFragmenta == null) {
                detailFragmenta = new DetailFragment();
                fragmentTransaction.add(R.id.frameLayoutDetail, detailFragmenta);
            }
            fragmentTransaction.commit();
        }
        masterFragment.setOnMasterSelectedListener(new MasterFragment.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(String layoutNumber) {
                sendLayoutNumber(layoutNumber);
            }
        });


        }

        //sendCLayoutNumber() method handles sending the layout number to DetailFragment

    private void sendLayoutNumber(String layoutNumber){
        DetailFragment detailFragment;
        if(dualPane){
            //Two pane layout
            detailFragment = (DetailFragment)
                    getSupportFragmentManager().findFragmentById(R.id.frameLayoutDetail);
            detailFragment.showSelectedLayout(layoutNumber);
        }
        else{
            //Single pane layout
            detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailFragment.KEY_LAYOUTS_NUMBER,layoutNumber);
            detailFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

}

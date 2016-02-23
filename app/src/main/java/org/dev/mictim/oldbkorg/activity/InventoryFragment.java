package org.dev.mictim.oldbkorg.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.dev.mictim.oldbkorg.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {
    private LinearLayout myLinearLayout;
    private TextView id;
    private TextView name;
    private TextView cost;
    private TextView duration;
    private TextView img;
    private TextView valueTV;

    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        Toast.makeText(getActivity().getApplicationContext(),AppConfig.response, Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }



}

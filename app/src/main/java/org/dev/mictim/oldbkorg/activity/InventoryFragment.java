package org.dev.mictim.oldbkorg.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import org.dev.mictim.oldbkorg.R;
import org.dev.mictim.oldbkorg.app.AppConfig;
import org.dev.mictim.oldbkorg.app.AppDisplayCurrentState;
import org.dev.mictim.oldbkorg.helper.FileOperations;
import org.dev.mictim.oldbkorg.helper.Helper;
import org.dev.mictim.oldbkorg.helper.JSONParser;
import org.dev.mictim.oldbkorg.helper.PostClass;
import org.dev.mictim.oldbkorg.pers.AppPersonInf;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {
    //

    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inventory, container, false);
        AppDisplayCurrentState newView = new AppDisplayCurrentState(rootView);
        newView.display(new InventoryFragment());

        return rootView;
    }



}

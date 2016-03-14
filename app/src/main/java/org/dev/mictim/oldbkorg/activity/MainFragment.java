package org.dev.mictim.oldbkorg.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.mictim.oldbkorg.R;
import org.dev.mictim.oldbkorg.app.AppDisplayCurrentState;
import org.dev.mictim.oldbkorg.helper.FileOperations;
import org.dev.mictim.oldbkorg.helper.Helper;
import org.dev.mictim.oldbkorg.helper.JSONParser;
import org.dev.mictim.oldbkorg.pers.AppPersonInf;
import org.dev.mictim.oldbkorg.pers.GoodInSlot;
import org.dev.mictim.oldbkorg.pers.Goods;
import org.dev.mictim.oldbkorg.pers.PersWear;

import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

//        AppPersonInf pers = new AppPersonInf(rootView);
//        pers.initialization();
//
//        String myInfoResp = new FileOperations(getContext(), "myinfo").readFromFile();
//        String myInvResp = new FileOperations(getContext(), "myinv").readFromFile();
//        Map<String, String> mapInfo = JSONParser.getValue(myInfoResp);
//        MainFragment mainFragment = new MainFragment();
//        pers.setPers(mapInfo, mainFragment);
//
//        PersWear persWear = new PersWear(rootView);
//        persWear.initialization();
//        List<GoodInSlot> goodInSlots = persWear.getGoodsId(mapInfo);
//        List<Goods> goods = Helper.getGoods(myInvResp);
//        persWear.drawing(goodInSlots, Helper.dressedGoods(goods));

        AppDisplayCurrentState newView = new AppDisplayCurrentState(rootView);
        newView.display(new MainFragment());

        return rootView;
    }


}

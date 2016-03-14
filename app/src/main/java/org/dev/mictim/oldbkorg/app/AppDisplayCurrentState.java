package org.dev.mictim.oldbkorg.app;

import android.support.v4.app.Fragment;
import android.view.View;

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
 * Created by elena on 3/14/16.
 */
public class AppDisplayCurrentState {
    private View view;

    public AppDisplayCurrentState(View view){
        this.view = view;
    }

    //displays current state of the char
    public void display(Fragment fragment){
        AppPersonInf pers = new AppPersonInf(view);
        //initialization of the TextView and ImageView objects
        pers.initialization();

        //Read data from file to parse it into objects
        String myInfoResp = new FileOperations(view.getContext(), "myinfo").readFromFile();
        String myInvResp = new FileOperations(view.getContext(), "myinv").readFromFile();
        //Make map from JSON fields
        Map<String, String> mapInfo = JSONParser.getValue(myInfoResp);
        //Set information about char, like Straight, Health and other
        pers.setPers(mapInfo, fragment);

        //Wardrobe initialization
        PersWear persWear = new PersWear(view);
        persWear.initialization();
        //Get goods in the slots and putting images in ImageView objects
        List<GoodInSlot> goodInSlots = persWear.getGoodsId(mapInfo);
        List<Goods> goods = Helper.getGoods(myInvResp);
        persWear.drawing(goodInSlots, Helper.dressedGoods(goods));
    }

}

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
import org.dev.mictim.oldbkorg.helper.JSONParser;
import org.dev.mictim.oldbkorg.helper.PostClass;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {
    private ImageView imgClan;
    private ImageView imgAlign;
    private TextView tvLogin;
    private TextView tvLevel;
    private TextView tvStreight;
    private TextView tvLovka;
    private TextView tvInta;
    private TextView tvVynos;
    private TextView tvIntel;
    private TextView tvMudra;

    //
    private ImageView imgClips;
    private ImageView imgAmulet;
    private ImageView imgWeapon;
    private ImageView imgArmor;
    private ImageView imgRing1;
    private ImageView imgRing2;
    private ImageView imgRing3;
    private ImageView imgHelmet;
    private ImageView imgPerchi;
    private ImageView imgShield;
    private ImageView imgBoots;
    private ImageView imgLogo;


    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inventory, container, false);
        PostClass port = new PostClass(rootView.getContext(), "myinfo");
        String responseInfo = port.getResponse();
        Map<String, String> mapInfo = JSONParser.getValue(responseInfo);

        imgClan = (ImageView) rootView.findViewById(R.id.imgClan);
        imgAlign = (ImageView) rootView.findViewById(R.id.imgAlign);
        tvLogin = (TextView) rootView.findViewById(R.id.tvLogin);
        tvLevel = (TextView) rootView.findViewById(R.id.tvLevel);
        tvStreight = (TextView) rootView.findViewById(R.id.tvStreight);
        tvLovka = (TextView) rootView.findViewById(R.id.tvLovka);
        tvInta = (TextView) rootView.findViewById(R.id.tvInta);
        tvVynos = (TextView) rootView.findViewById(R.id.tvHealth);
        tvIntel = (TextView) rootView.findViewById(R.id.tvIntellect);
        tvMudra = (TextView) rootView.findViewById(R.id.tvMudra);

        imgClips = (ImageView) rootView.findViewById(R.id.imgClips);
        imgAmulet = (ImageView) rootView.findViewById(R.id.imgAmulet);
        imgWeapon = (ImageView) rootView.findViewById(R.id.imgWeapon);
        imgArmor = (ImageView) rootView.findViewById(R.id.imgArmor1);
        imgRing1 = (ImageView) rootView.findViewById(R.id.imgRing1);
        imgRing2 = (ImageView) rootView.findViewById(R.id.imgRing2);
        imgRing3 = (ImageView) rootView.findViewById(R.id.imgRing3);
        imgHelmet = (ImageView) rootView.findViewById(R.id.imgHelmet);
        imgPerchi = (ImageView) rootView.findViewById(R.id.imgPerchi);
        imgShield = (ImageView) rootView.findViewById(R.id.imgShield);
        imgBoots = (ImageView) rootView.findViewById(R.id.imgBoots);
        imgLogo = (ImageView) rootView.findViewById(R.id.imgAvatar);


        if (mapInfo.size() > 0) {
//                    AppConfig.responseMap = map;
            tvLogin.setText(mapInfo.get("login"));
            tvLevel.setText("[" + mapInfo.get("level") + "]");
            String strAlign = "http://oldbk.org/i/align_" + mapInfo.get("align") + ".gif";
            UrlImageViewHelper.setUrlDrawable(imgAlign, strAlign);
            String strKlan = "http://oldbk.org/i/klan/" + mapInfo.get("klan") + ".gif";
            UrlImageViewHelper.setUrlDrawable(imgClan, strKlan);
            tvStreight.setText(tvStreight.getText() + " " + mapInfo.get("sila"));
            tvLovka.setText(tvLovka.getText() + " " + mapInfo.get("lovk"));
            tvInta.setText(tvInta.getText() + " " + mapInfo.get("inta"));
            tvVynos.setText(tvVynos.getText() + " " + mapInfo.get("vinos"));
            tvIntel.setText(tvIntel.getText() + " " + mapInfo.get("intel"));
            tvMudra.setText(tvMudra.getText() + " " + mapInfo.get("mudra"));
        } else {
            Toast.makeText(getContext(),
                    "Error", Toast.LENGTH_LONG).show();
        }

//        PostClass port1 = new PostClass(rootView.getContext(), "myinv");
//        String responseInv = port.getResponse();
//        String[] responseInvArray = responseInv.split("}");

//        Map<String, String> mapInv = JSONParser.getValue(responseInfo);




//        Toast.makeText(getActivity().getApplicationContext(),AppConfig.response, Toast.LENGTH_LONG).show();
        return rootView;
    }



}

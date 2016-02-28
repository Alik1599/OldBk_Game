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
public class MainFragment extends Fragment {
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
    private TextView tvWins;
    private TextView tvLose;
    private TextView tvMoney;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        PostClass port = new PostClass(getContext(), "myinfo");
        String response = port.getResponse();
        Map<String, String> map = JSONParser.getValue(response);

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
        tvWins = (TextView) rootView.findViewById(R.id.tvWins);
        tvLose = (TextView) rootView.findViewById(R.id.tvLose);
        tvMoney = (TextView) rootView.findViewById(R.id.tvMoney);


        if (map.size() > 0) {
//                    AppConfig.responseMap = map;
            tvLogin.setText(map.get("login"));
            tvLevel.setText("[" + map.get("level") + "]");
            String strAlign = "http://oldbk.org/i/align_" + map.get("align") + ".gif";
            UrlImageViewHelper.setUrlDrawable(imgAlign, strAlign);
            String strKlan = "http://oldbk.org/i/klan/" + map.get("klan") + ".gif";
            UrlImageViewHelper.setUrlDrawable(imgClan, strKlan);
            tvStreight.setText(tvStreight.getText() + " " + map.get("sila"));
            tvLovka.setText(tvLovka.getText() + " " + map.get("lovk"));
            tvInta.setText(tvInta.getText() + " " + map.get("inta"));
            tvVynos.setText(tvVynos.getText() + " " + map.get("vinos"));
            tvIntel.setText(tvIntel.getText() + " " + map.get("intel"));
            tvMudra.setText(tvMudra.getText() + " " + map.get("mudra"));
            tvWins.setText(tvWins.getText() + " " + map.get("win"));
            tvLose.setText(tvLose.getText() + " " + map.get("lose"));

            tvMoney.setText(tvMoney.getText() + " " + map.get("money"));


        } else {
            Toast.makeText(getContext(),
                    "Error", Toast.LENGTH_LONG).show();
        }
//            UrlImageViewHelper.setUrlDrawable(imgClan, "http://oldbk.org/i/klan/MiB.gif");

        // Inflate the layout for this fragment
        return rootView;
    }


}

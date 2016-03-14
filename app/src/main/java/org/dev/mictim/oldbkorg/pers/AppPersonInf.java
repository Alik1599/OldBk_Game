package org.dev.mictim.oldbkorg.pers;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import org.dev.mictim.oldbkorg.R;
import org.dev.mictim.oldbkorg.activity.InventoryFragment;
import org.dev.mictim.oldbkorg.activity.MainFragment;

import java.util.Map;

/**
 * Created by elena on 3/5/16.
 */
public class AppPersonInf {
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
    private View view;

    public AppPersonInf(View view){
        this.view = view;
    }

    public void initialization (){
        imgClan = (ImageView) view.findViewById(R.id.imgClan);
        imgAlign = (ImageView) view.findViewById(R.id.imgAlign);
        tvLogin = (TextView) view.findViewById(R.id.tvLogin);
        tvLevel = (TextView) view.findViewById(R.id.tvLevel);
        tvStreight = (TextView) view.findViewById(R.id.tvStreight);
        tvLovka = (TextView) view.findViewById(R.id.tvLovka);
        tvInta = (TextView) view.findViewById(R.id.tvInta);
        tvVynos = (TextView) view.findViewById(R.id.tvHealth);
        tvIntel = (TextView) view.findViewById(R.id.tvIntellect);
        tvMudra = (TextView) view.findViewById(R.id.tvMudra);
        tvWins = (TextView) view.findViewById(R.id.tvWins);
        tvLose = (TextView) view.findViewById(R.id.tvLose);
        tvMoney = (TextView) view.findViewById(R.id.tvMoney);
    }

    public void setPers (Map map, Fragment fragment){

        if (map.size() > 0) {
            if (fragment instanceof MainFragment){
                tvLogin.setText((CharSequence) map.get("login"));
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

            } else if (fragment instanceof InventoryFragment){
                tvLogin.setText((CharSequence) map.get("login"));
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
            }

        } else {
            Toast.makeText(view.getContext(),
                    "Error", Toast.LENGTH_LONG).show();
        }
    }
}

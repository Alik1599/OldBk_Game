package org.dev.mictim.oldbkorg.pers;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import org.dev.mictim.oldbkorg.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PersWear {
    private Goods good;

    private ImageView sergi;
    private ImageView kulon;
    private ImageView perchi;
    private ImageView weap;
    private ImageView bron;
    private ImageView r1;
    private ImageView r2;
    private ImageView r3;
    private ImageView helm;
    private ImageView shit;
    private ImageView boots;
    private ImageView runa1;
    private ImageView runa2;
    private ImageView runa3;
    private ImageView rybax;
    private ImageView venok;
    private ImageView plaw;
    private View view;

    public PersWear(View view){
        this.view = view;
    }

    public void initialization(){
        sergi = (ImageView) view.findViewById(R.id.imgClips);
        kulon = (ImageView) view.findViewById(R.id.imgAmulet);
        perchi = (ImageView) view.findViewById(R.id.imgPerchi);
        weap = (ImageView) view.findViewById(R.id.imgWeapon);
        bron = (ImageView) view.findViewById(R.id.imgBron);
        r1 = (ImageView) view.findViewById(R.id.imgRing1);
        r2 = (ImageView) view.findViewById(R.id.imgRing2);
        r3 = (ImageView) view.findViewById(R.id.imgRing3);
        helm = (ImageView) view.findViewById(R.id.imgHelmet);
        shit = (ImageView) view.findViewById(R.id.imgShield);
        boots = (ImageView) view.findViewById(R.id.imgBoots);
        rybax = (ImageView) view.findViewById(R.id.imgArmor1);
        venok = (ImageView) view.findViewById(R.id.imgVenok);
        plaw = (ImageView) view.findViewById(R.id.imgPlaw);

    }

    public void drawing(List<GoodInSlot> ids, List<Goods> goods){
        for (GoodInSlot id : ids){
            for (Goods good: goods) {
                if((id.getId()).equals(good.getId())){
                    drawGood(id.getSlot(), good.getImg());
                }
            }
        }

    }

    public List<GoodInSlot> getGoodsId(Map mapInfo){
        List<GoodInSlot> list = new ArrayList<>();
        if (mapInfo.size() > 0){
            list.add(new GoodInSlot("sergi", (String) mapInfo.get("sergi")));
            list.add(new GoodInSlot("kulon", (String) mapInfo.get("kulon")));
            list.add(new GoodInSlot("perchi",(String) mapInfo.get("perchi")));
            list.add(new GoodInSlot("weap", (String) mapInfo.get("weap")));
            list.add(new GoodInSlot("bron", (String) mapInfo.get("bron")));
            list.add(new GoodInSlot("r1", (String) mapInfo.get("r1")));
            list.add(new GoodInSlot("r2", (String) mapInfo.get("r2")));
            list.add(new GoodInSlot("r3", (String) mapInfo.get("r3")));
            list.add(new GoodInSlot("helm", (String) mapInfo.get("helm")));
            list.add(new GoodInSlot("shit", (String) mapInfo.get("shit")));
            list.add(new GoodInSlot("boots", (String) mapInfo.get("boots")));
            list.add(new GoodInSlot("rybax", (String) mapInfo.get("rybax")));
            list.add(new GoodInSlot("venok", (String) mapInfo.get("venok")));
            list.add(new GoodInSlot("plaw", (String) mapInfo.get("plaw")));
            list.add(new GoodInSlot("runa1", (String) mapInfo.get("runa1")));
            list.add(new GoodInSlot("runa2", (String) mapInfo.get("runa2")));
            list.add(new GoodInSlot("runa3", (String) mapInfo.get("runa3")));
        }
        return list;
    }

    private void drawGood(String name, String url){
            switch(name){
                case "sergi":
                    UrlImageViewHelper.setUrlDrawable(sergi, url);
                    sergi.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "kulon":
                    UrlImageViewHelper.setUrlDrawable(kulon, url);
                    kulon.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "perchi":
                    UrlImageViewHelper.setUrlDrawable(perchi, url);
                    perchi.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "weap":
                    UrlImageViewHelper.setUrlDrawable(weap, url);
                    weap.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "rybax":
                    UrlImageViewHelper.setUrlDrawable(rybax, url);
                    rybax.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "bron":
                    bron.setVisibility(View.VISIBLE);
                    bron.setMaxHeight(80);
                    bron.setMaxWidth(60);
                    bron.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    UrlImageViewHelper.setUrlDrawable(bron, url);
                    break;
                case "r1":
                    UrlImageViewHelper.setUrlDrawable(r1, url);
                    r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "r2":
                    UrlImageViewHelper.setUrlDrawable(r2, url);
                    r2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "r3":
                    UrlImageViewHelper.setUrlDrawable(r3, url);
                    r3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "helm":
                    UrlImageViewHelper.setUrlDrawable(helm, url);
                    helm.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "shit":
                    UrlImageViewHelper.setUrlDrawable(shit, url);
                    shit.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "boots":
                    UrlImageViewHelper.setUrlDrawable(boots, url);
                    boots.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "venok":
                    venok.setVisibility(View.VISIBLE);
                    UrlImageViewHelper.setUrlDrawable(venok, url);
                    venok.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "plaw":
                    plaw.setVisibility(View.VISIBLE);
                    UrlImageViewHelper.setUrlDrawable(plaw, url);
                    plaw.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "runa1":
                    UrlImageViewHelper.setUrlDrawable(runa1, url);
                    runa1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "runa2":
                    UrlImageViewHelper.setUrlDrawable(runa2, url);
                    runa2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case "runa3":
                    UrlImageViewHelper.setUrlDrawable(runa3, url);
                    runa3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                default:
                    Log.w("Nothing to wear: ", name);
            }
    }



}

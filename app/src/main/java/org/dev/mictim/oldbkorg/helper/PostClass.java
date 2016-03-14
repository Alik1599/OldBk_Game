package org.dev.mictim.oldbkorg.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.dev.mictim.oldbkorg.app.AppConfig;
import org.dev.mictim.oldbkorg.app.AppController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mictim on 2/26/16.
 */
public class PostClass extends AsyncTask<String,Void,String>{
    private FileOperations fo = null;
    private Context context;
    private String filename;

    public PostClass(Context context, String filename){
        this.context = context;
        this.filename = filename;
        fo = new FileOperations(context, filename);
    }

    public PostClass(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params){
        String url = params[0];
        InputStream is = openConnection(url);
        String response = convertIS2String(is);
        return response;

    }

    @Override
    protected void onPostExecute(String str){
        //Set the background

        fo.writeToFile(str);

    }

    //Connect to the Internet using URL, get back the InputString
    private InputStream openConnection(String urlStr){
        InputStream is = null;
        try {
            java.net.URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            if (con instanceof HttpURLConnection){
                //cast it into the HttpURLConnection
                HttpURLConnection httpURLConnection = (HttpURLConnection)con;
                int response = -1;
                httpURLConnection.connect();
                response = httpURLConnection.getResponseCode();
                if(response == HttpURLConnection.HTTP_OK){
                    is = httpURLConnection.getInputStream();

                }
            }

        } catch (Exception e){
            Log.e("Error: ", e.toString());
        }
        return is;
    }

    private String convertIS2String(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
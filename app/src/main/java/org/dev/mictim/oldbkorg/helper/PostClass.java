package org.dev.mictim.oldbkorg.helper;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.dev.mictim.oldbkorg.app.AppConfig;
import org.dev.mictim.oldbkorg.app.AppController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mictim on 2/26/16.
 */
public class PostClass extends Activity {
    private String filename;
    private List<String[]> args = null;
    private Context context;


    public PostClass(Context context, String filename, List<String[]> args) {
        this.filename = filename;
        this.args = args;
        this.context = context;
    }

    public PostClass(Context context, String filename) {
        this.filename = filename;
        this.context = context;
    }

    public void post(String TAG) {
        //showDialog();

        Response.Listener listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                FileOperations fo = new FileOperations(context, filename);
                Log.d(filename, "Response: " + response.toString());
//                Toast.makeText(context,
//                        response, Toast.LENGTH_LONG).show();
                fo.writeToFile(response);
                Log.d(filename, "file created");
//                AppConfig.response = response.toString();


            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(filename, " Error: " + error.getMessage());
                Toast.makeText(context,
                        error.getMessage(), Toast.LENGTH_LONG).show();
                //hideDialog();
            }
        };

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, listener, errorListener) {
            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                for (int i = 0; i < args.size(); i++) {
                    params.put(args.get(i)[0], args.get(i)[1]);
                }

                return params;
            }


        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, TAG);

    }

    public String getResponse() {


        FileOperations fo1 = new FileOperations(context, filename);
        AppConfig.response = fo1.readFromFile();
        Log.d(filename, "file read " + AppConfig.response);
        return AppConfig.response;
    }
}

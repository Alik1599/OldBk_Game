package org.dev.mictim.oldbkorg.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.dev.mictim.oldbkorg.R;
import org.dev.mictim.oldbkorg.app.AppConfig;
import org.dev.mictim.oldbkorg.helper.FileOperations;
import org.dev.mictim.oldbkorg.helper.SessionManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    private SessionManager session;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        FileOperations fo = new FileOperations(getApplicationContext(), "sid");
        AppConfig.sid = fo.readFromFile();
        AppConfig.myInfoSid[1] = AppConfig.sid;
        AppConfig.myInvSid[1] = AppConfig.sid;
        Log.d("sid:", AppConfig.sid);

        //Set the fragment initially
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //How to change elements in the header programatically
//        View headerView = navigationView.getHeaderView(0);
//        TextView emailText = (TextView) headerView.findViewById(R.id.email);
//        emailText.setText("newemail@email.com");

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout){
            session = new SessionManager(getApplicationContext());
            session.setLogin(false);
//            FileOperations fo = new FileOperations(getApplicationContext());
//            fo.deleteFile("sid");
//            fo.deleteFile("login");
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String response = null;
        int id = item.getItemId();

        if (id == R.id.nav_stats) {
            //Get response
//            PostClass post = new PostClass(getApplicationContext(), "myinfo");
//            String myInfoResponse = post.getResponse();
//            Toast.makeText(getApplicationContext(),
//                    myInfoResponse, Toast.LENGTH_LONG).show();
            //Set the fragment initially
            MainFragment fragment = new MainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            // Handle the camera action
        } else if (id == R.id.nav_inventory) {
            //Get response
//            PostClass post = new PostClass(getApplicationContext(), "myinv");
//            String myInvResponse = post.getResponse();
//            Toast.makeText(getApplicationContext(),
//                    myInvResponse, Toast.LENGTH_LONG).show();

            InventoryFragment fragment = new InventoryFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_bag) {

        } else if (id == R.id.nav_state) {

        } else if (id == R.id.nav_chatlist) {

        } else if (id == R.id.nav_chat) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void post (final List<String[]> args, final String location){
//        showDialog();
//
//        Response.Listener listener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Log.d(TAG, location + " response: " + response.toString());
////                Toast.makeText(getApplicationContext(),
////                        response, Toast.LENGTH_LONG).show();
//                AppConfig.response = response.toString();
//
//
//            }
//        };
//        Response.ErrorListener errorListener = new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, location + " Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(),
//                        error.getMessage(), Toast.LENGTH_LONG).show();
//                hideDialog();
//            }
//        };
//
//        StringRequest strReq = new StringRequest(Request.Method.POST,
//                AppConfig.URL_LOGIN, listener, errorListener){
//            @Override
//            public Priority getPriority() {
//                return Priority.IMMEDIATE;
//            }
//
//            @Override
//            protected Map<String, String> getParams() {
//                // Posting parameters to login url
//                Map<String, String> params = new HashMap<String, String>();
//                for (int i = 0; i < args.size(); i++){
//                    params.put(args.get(i)[0],args.get(i)[1]);
//                }
//
//                return params;
//            }
//
//
//        };
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(strReq, null);
//
//    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}

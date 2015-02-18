package com.example.yadu.hotel_menu_mark_1;


import android.app.ProgressDialog;
import android.content.res.Resources;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import com.example.yadu.hotel_menu_mark_1.common.view.SlidingTabLayout;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class server_data extends MainActivity {

    ViewPager mViewPager;
    private ProgressDialog progress;
    static final String LOG_TAG = "SlidingTabsBasicFragment";

    private static final String URL = "http://opensalesme.com/menu/fetch_db_items.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_ITEMS="name";
    private static final String TAG_DESCRPTION="description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter);
        //passing global data to all the activities
        nitView();
        initDrawer();
        toolbar.setTitle("Starter");
        setSupportActionBar(toolbar);

        progress= new ProgressDialog(this);
        new DownloadWebPageTask().execute();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();


    }


        private class DownloadWebPageTask extends AsyncTask<Void, Void, String> {

        int fd_pin;
        String fd_item="",fd_descp="";

        @Override
        protected void onPreExecute(){
            progress.setMessage("Attempting to retrieve menu items... ");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            progress.show();
        }

        @Override
        protected String doInBackground(Void... urls) {
            int success;
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            http_connector ht = new http_connector();
            String result = ht.getdata(params,URL);
            return result;
        }

        // @Override
        protected void onPostExecute(String result) {
            progress.cancel();
            Log.d("Constants", "backgound-"+result);
            Log.d("Constants", "in post execute.");
            try{
                Log.d("json","atleast here");
                Log.d("result",result);

                JSONObject json_data = new JSONObject(result);

                Log.d("json","before parse");
                fd_pin=json_data.getInt(TAG_SUCCESS);
                fd_item=json_data.getString(TAG_ITEMS);
                fd_descp=json_data.getString(TAG_DESCRPTION);

                Log.d("json","parsing done");
                //  }

            }catch(JSONException e1){
                Toast.makeText(getBaseContext(), "No Food Found", Toast.LENGTH_LONG).show();
            }catch (ParseException e1){
                e1.printStackTrace();
            }

        }
    }


}



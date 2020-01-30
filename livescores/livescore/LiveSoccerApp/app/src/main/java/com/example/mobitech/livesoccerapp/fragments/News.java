package com.example.mobitech.livesoccerapp.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mobitech.livesoccerapp.adapters.ListAdapter_lastestnews;
import com.example.mobitech.livesoccerapp.App.AppController;
import com.example.mobitech.livesoccerapp.App.Constants;
import com.example.mobitech.livesoccerapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class News extends Fragment {
    // json array response url
    private String urlJsonArry = "http://www.elacomms.com/kimeli/livescore/events.php";
    private static String TAG = News.class.getSimpleName();
    private ListView mListView;
    // Progress dialog
    private ProgressDialog pDialog;
    public ListAdapter_lastestnews listAdapter;
    private ListView listView;
    public ArrayList<Constants> live_data_list = new ArrayList<Constants>();
    RelativeLayout content_main;
    Constants constants;
    View rootView;


    public News() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.news, container, false);
        // listView = (ListView) rootView.findViewById(R.id.listView);
        content_main = (RelativeLayout) rootView.findViewById(R.id.content_main);
        this.mListView = (ListView) rootView.findViewById(R.id.list_tracks);
        listAdapter = new ListAdapter_lastestnews(this);
        // listView.setAdapter(listAdapter);
        mListView.setDivider(null);
        mListView.setAdapter(listAdapter);
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        makeJsonArrayRequest();

        return rootView;
    }



    private void makeJsonArrayRequest() {
        String tag_string_req1 = "string_req";
        // Defined Array values to show in ListView
        final ProgressDialog pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Loading...");
        pDialog.show();
        StringRequest strReq1 = new StringRequest(Request.Method.GET,
                urlJsonArry, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for(int i = 0; i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        constants = new Constants();
                        constants.date = jsonObject1.getString("date");
                        constants.title = jsonObject1.getString("title");
                        constants.type = jsonObject1.getString("type");
                        constants.image_url = jsonObject1.getString("img_url");
                        constants.new_desc = jsonObject1.getString("new_desc");
                        constants.new_url = jsonObject1.getString("new_url");
                        live_data_list.add(constants);

                    }




                    listAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

                pDialog.hide();

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                String message = null;
                if (error instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (error instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (error instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (error instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }


//                Toast.makeText(getContext(), message + "income", Toast.LENGTH_LONG).show();

                pDialog.hide();
            }
        }) {

        };

        // Adding request to request queue
        AppController.getInstance().

                addToRequestQueue(strReq1, tag_string_req1);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

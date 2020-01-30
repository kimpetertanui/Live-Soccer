package com.example.mobitech.livesoccerapp.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
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
import com.example.mobitech.livesoccerapp.App.AppController;
import com.example.mobitech.livesoccerapp.App.Constants;
import com.example.mobitech.livesoccerapp.R;
import com.example.mobitech.livesoccerapp.adapters.ListAdapter_live_matches;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Live_matches_Fragment extends Fragment {
    public static  String count_str="0";
    String urlJsonArry = "http://www.elacomms.com/kimeli/livescore/live.php";
    TextView NomatchFound, data;

    String currentdate;
    Constants constants;
    ListView listView;
    ListAdapter_live_matches listAdapter_live_matches;
    public ArrayList<Constants> live_data_list = new ArrayList<Constants>();
    View rootView;


    public Live_matches_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.live, container, false);
        NomatchFound = (TextView) rootView.findViewById(R.id.NomatchFound);
        listView = (ListView) rootView.findViewById(R.id.data);
        listAdapter_live_matches = new ListAdapter_live_matches(this);
        listView.setAdapter(listAdapter_live_matches);
        listView.setDivider(null);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        currentdate = df.format(Calendar.getInstance().getTime());

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
                    JSONArray stories = jsonObject.getJSONArray("data");
                    for (int i = 0; i < stories.length(); i++) {
                        constants = new Constants();
                        JSONObject jsonObject1 = stories.getJSONObject(i);

//                        String data_ht_score = jsonObject1.getString("ht_score");
//                        String data_ft_score = jsonObject1.getString("ft_score");
//
//                        String data_away_team_logo = jsonObject1.getString("away_team_logo");
//
//                        String data_home_score_penalities = jsonObject1.getString("home_score_penalties");
//                        String data_away_score_penalties = jsonObject1.getString("away_score_penalties");
//                        String data_spectators = jsonObject1.getString("spectators");
//
//                        String data_starting_time = jsonObject1.getString("starting_time");
//                        String data_status = jsonObject1.getString("status");
//
//                        String data_extra_minute = jsonObject1.getString("extra_minute");
//                        String data_compitition_id = jsonObject1.getString("competition_id");
//                        String data_competition_name = jsonObject1.getString("competition_name");
//                        String data_venue_id = jsonObject1.getString("venue_id");
//                        String data_venue_name = jsonObject1.getString("venue_name");
//                        String data_venue_city = jsonObject1.getString("venue_city");
//                        String data_season_id = jsonObject1.getString("season_id");
//                        String data_season_name = jsonObject1.getString("season_name");
//                        String data_round_id = jsonObject1.getString("stage_id");
//                        String data_aggregate = jsonObject1.getString("aggregate");
//                        String data_placeholder = jsonObject1.getString("placeholder");
//                        String data_country_id = jsonObject1.getString("country_id");

//                        String data_league_name=jsonObject1.getString("league_name");
                        String data_home_id=jsonObject1.getString("home_id");
                        String data_status=jsonObject1.getString("status");
                        String data_home_name=jsonObject1.getString("home_name");
                        String data_id=jsonObject1.getString("id");
                        String data_competition_id=jsonObject1.getString("competition_id");
                        String data_away_id=jsonObject1.getString("away_id");
                        String data_ht_score=jsonObject1.getString("ht_score");
                        String data_added=jsonObject1.getString("added");
                        String data_score=jsonObject1.getString("score");
                        String data_competition_name=jsonObject1.getString("competition_name");
                        String data_fixture_id=jsonObject1.getString("fixture_id");
                        String away_name=jsonObject1.getString("away_name");
                        String data_events=jsonObject1.getString("events");
                        String data_scheduled=jsonObject1.getString("scheduled");
                        String data_et_score=jsonObject1.getString("et_score");
                        String data_league_id=jsonObject1.getString("league_id");
                        String data_location=jsonObject1.getString("location");
                        String data_time=jsonObject1.getString("time");
                        String data_last_changed=jsonObject1.getString("last_changed");
                        String data_ft_score=jsonObject1.getString("ft_score");
                        String data_outcomes=jsonObject1.getString("outcomes");
                        //   Toast.makeText(Live_matches.this, data_starting_date+"mdmd", Toast.LENGTH_SHORT).show();
                        if ((jsonObject1.getString("status")).equals("LIVE")) {
//                            constants.data_id = jsonObject1.getString("id");
//                            constants.data_home_team_id = jsonObject1.getString("home_team_id");
//                            constants.data_away_team_id = jsonObject1.getString("away_team_id");
//                            constants.data_venue_name = jsonObject1.getString("venue_name");
//                            constants.data_venue_city = jsonObject1.getString("venue_city");
//                           constants.data_minute = jsonObject1.getString("minute");
//                            constants.data_home_team_name = jsonObject1.getString("home_team_name");
//                            constants.data_country_name = jsonObject1.getString("country_name");
//                            constants.data_country_flag = jsonObject1.getString("country_flag");
//                            constants.data_away_team_name = jsonObject1.getString("away_team_name");
//                            constants.data_home_score = jsonObject1.getString("home_score");
//                            constants.data_away_score = jsonObject1.getString("away_score");
//                            constants.data_starting_date = jsonObject1.getString("starting_date");
//                            constants.data_home_team_logo = jsonObject1.getString("home_team_logo");
//                            constants.data_away_team_logo = jsonObject1.getString("away_team_logo");
                            constants.data_id = jsonObject1.getString("id");
                            constants.data_home_team_id = jsonObject1.getString("home_id");
                            constants.data_away_team_id = jsonObject1.getString("away_id");
                            constants.data_home_team_name = jsonObject1.getString("home_name");
                            constants.data_away_team_name = jsonObject1.getString("away_name");
                            NomatchFound.setVisibility(View.GONE);
                            live_data_list.add(constants);
                           int count = listAdapter_live_matches.getCount();
                           count_str=String.valueOf(count);
                        }
                    }

                   // Toast.makeText(getContext(),count_str, Toast.LENGTH_SHORT).show();
                    listAdapter_live_matches.notifyDataSetChanged();

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


                //    Toast.makeText(getContext(), message + "income", Toast.LENGTH_LONG).show();

                pDialog.hide();
            }
        }) {

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq1, tag_string_req1);
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

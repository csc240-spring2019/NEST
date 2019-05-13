package edu.ncc.nest.nestapp;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodPantryLifeActivity extends ListActivity {

    private FoodInfoSource datasource;
    private ArrayAdapter<FoodEntry> adapter;
    private boolean done = false;
//    private static final String TAG_NAME = "name";
//    private static final String TAG_MIN = "min";
//    private static final String TAG_MAX = "max";
//    private static final String TAG_METRIC = "metric";

//    ArrayList<HashMap<String, String>> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_pantry_life);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        datasource = new FoodInfoSource(this);
        datasource.open();

//        foodList = new ArrayList<>();

//        new GetFood().execute();
    }

    public void onClick(View view) {
        FoodEntry food;
        List<FoodEntry> values;
        switch (view.getId()) {
            case R.id.createdb:
                new GetFood().execute();
                break;
            case R.id.usedb:
                done = true;
                break;
            case R.id.show:
                if(done){
                    values = datasource.getAllFoods();
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
                    setListAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
        }
    }

    public void onDestroy()
    {
        datasource.close();
        super.onDestroy();
    }

    private class GetFood extends AsyncTask<Void, Void, Void> {
        String result = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpURLConnection urlConnection;
            BufferedReader reader;

            try {
                URL url = new URL("https://foodkeeper-api.herokuapp.com/products/category/23");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String s;
                while ((s = reader.readLine()) != null) {
                    result += s;
                }
            } catch (Exception e) {
                Log.i("HttpAsyncTask", "EXCEPTION: " + e.getMessage());
            }

            Log.i("PARSING", "Returned string: " + result);
            return null;

        }

        @Override
        protected void onPostExecute(Void r) {
            super.onPostExecute(r);

            if (result.length() != 0) {
                Log.i("Parsing", "about to start" + result);
                try {
                    JSONObject jsonObj = new JSONObject(result);
                    JSONArray shelfStableFoods = jsonObj.getJSONArray(result);

                    for (int i = 0; i < shelfStableFoods.length(); i++) {
                        JSONObject temp = shelfStableFoods.getJSONObject(i);
                        String name = temp.getString("name");
                        JSONObject pantryLife = temp.getJSONObject("dop_pantryLife");
                        int min = pantryLife.getInt("min");
                        int max = pantryLife.getInt("max");
                        String metric = pantryLife.getString("metric");

                        datasource.addFood(name, min, max, metric);
//                        HashMap<String, String> food = new HashMap<>();

//                        food.put(TAG_NAME, name);
//                        food.put(TAG_MIN, String.valueOf(min));
//                        food.put(TAG_MAX, String.valueOf(max));
//                        food.put(TAG_METRIC, metric);
//
//                        foodList.add(food);

//                        ListAdapter adapter = new SimpleAdapter(
//                                FoodPantryLifeActivity.this, foodList,
//                                R.layout.list_item, new String[]{TAG_NAME, TAG_MIN,
//                                TAG_MAX, TAG_METRIC},
//                                new int[]{R.id.identifier, R.id.name, R.id.title,
//                                        R.id.format, R.id.id});
//
//                        ListView myList = (ListView) findViewById(R.id.list);
//                        myList.setAdapter(adapter);
                    }

                    Toast toast = Toast.makeText(getApplicationContext(),"Database Created!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                    done = true;

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
        }
    }
}


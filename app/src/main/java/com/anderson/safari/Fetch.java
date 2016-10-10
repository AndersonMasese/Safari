package com.anderson.safari;

/**
 * Created by Anderson on 10/3/2016.
 */
public class Fetch extends Activity {
    ArrayList<Flowers> flowersList = new ArrayList<Flowers>();
    String url ="http://services.hanselandpetal.com/feeds/flowers.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch);


        new BackTask().execute(url);
    }

    public class BackTask extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String content =HttpULRConnect.getData(url);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            try {


                JSONArray ar = new JSONArray(s);
                for (int i=0; i<ar.length(); i++){
                    JSONObject jsonobject = ar.getJSONObject(i);
                    Flowers  flowers = new Flowers();
                    flowers.setName(jsonobject.getString("name"));
                    flowersList.add(flowers);

                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }
            FlowerAdapter adapter = new FlowerAdapter(Fetch.this, R.layout.flowers_list_items, flowersList);
            ListView lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adapter);
            //Log.d("recived",s);


        }
    }



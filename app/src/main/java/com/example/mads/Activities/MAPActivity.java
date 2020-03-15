package com.example.mads.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mads.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MAPActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    private TextView mSearchText;

    private static final String TAG = "MAPActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mSearchText = (TextView) findViewById(R.id.input_search);


        Toolbar mtoolbar = findViewById(R.id.maptoolbar);

        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("MAP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MAPActivity.this, Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapid);
        mapFragment.getMapAsync(this);
    }

   /* private void init(){
        Log.d(TAG, "init: initializing");
        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH
                          || actionId == EditorInfo.IME_ACTION_SEARCH
                          || keyEvent.getAction() == keyEvent.ACTION_DOWN
                          || keyEvent.getAction() == keyEvent.KEYCODE_ENTER) {
                    geoLocate();

                }
                return false;
            }
        });


    }*/
    /*private void geoLocate(){
        Log.d(TAG, "geoLocate: geolocating");
        String searchString = mSearchText.getText().toString();
        Geocoder geocoder = new Geocoder(MAPActivity.this);
        List<Address> list = new ArrayList<>();
        try{
            list = geocoder.getFromLocationName(searchString, 1);
        }
          catch (IOException e){
              Log.e(TAG, "geoLocate: IOException: "+ e.getMessage());
          }
          if(list.size() > 0){
              Address address = list.get(0);
              Log.d(TAG, "geoLocate: found a location " + address.toString());
          }
        
    }
*/
    @Override
    public void onMapReady(GoogleMap googleMap)   {

        map = googleMap;
        LatLng Njoro = new LatLng(-0.373940, 35.962223);
        map.addMarker(new MarkerOptions().position(Njoro).title("Njoro"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Njoro));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.normal_map:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.hybrid_map:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.satellite_map:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.terrain_map:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            /*case R.id.back:
                startActivity(new Intent(MAPActivity.this, Home.class));
                finish();
                return true;*/

                default:
                    return super.onOptionsItemSelected(item);

        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                startActivity(new Intent(MAPActivity.this, Home.class));
                finish();
                return true;
        }
        return false;
    }*/

}

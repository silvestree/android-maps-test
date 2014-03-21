package br.com.silvestre.teste;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

@SuppressLint("NewApi")
public class HelloAndroidActivity extends FragmentActivity {
    private LatLng frameworkSystemLocation = new LatLng(-20.397833,-43.50906);
    private GoogleMap map;
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();
        //Adiciona um ponto no mapa no local pré determinado 
        Marker frameworkSystem = map.addMarker(new MarkerOptions()
       .position(frameworkSystemLocation).title("Framework System"));
        // Move a câmera para Framework System com zoom 15.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(frameworkSystemLocation , 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
        //Marca sua posição no mapa
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setCompassEnabled(true); 
        map.setMyLocationEnabled(true);  

        
    }
}
package com.route.cities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.route.cities.data.models.City
import com.route.cities.presentation.HomeScreen
import com.route.cities.ui.theme.CitiesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CitiesTheme {
                HomeScreen{ city ->
                    locationOfCity(city = city)
                }
            }
        }
    }
    private fun locationOfCity(city: City){
        val geoUri = "geo:${city.coord?.lat},${city.coord?.lon}?z=15"
        Log.d("TAG","geo = $geoUri")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Google Maps is not available", Toast.LENGTH_SHORT).show()
        }
    }
}



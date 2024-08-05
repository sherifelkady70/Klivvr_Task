package com.route.cities.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.cities.data.models.City
import com.route.cities.data.models.Coord

@Composable
fun HomeScreen(cities : List<City>){
    //val cities = CitiesDataManager(ApplicationClass.context).getCities()
    Column(modifier = Modifier.padding(8.dp)){
        TextField(value = "Search", onValueChange = {} , Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(5.dp))
        LazyColumn {
            items(cities){ city ->
                CityDetails(city = city)
            }

        }
    }
}

@Composable
fun CityDetails(city:City){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()) {
        Column (modifier = Modifier.padding(8.dp)){
            Row {
                Text(text = city.name.toString())
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = city.country.toString())
            }
            Row {
                Text(text = city.coord?.lon.toString())
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = city.coord?.lat.toString())
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    HomeScreen(
        listOf(
            City("EGY", name = "Cairo", coord = Coord("55555555", "101010101")),
            City("EGY", name = "Cairo", coord = Coord("5555555", "101010101")),
            City("EGY", name = "Cairo", coord = Coord("777777", "101010101")),
            City("EGY", name = "Cairo", coord = Coord("8888888", "101010101")),
            City("EGY", name = "Cairo", coord = Coord("5555555", "101010101"))
        )
    )
}
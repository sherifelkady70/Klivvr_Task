package com.route.cities.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.route.cities.data.models.City
import com.route.cities.data.models.Coord

@Composable
fun HomeScreen(onClick: (City) -> Unit){
    val viewModel = hiltViewModel<HomeScreenViewModel>()
//    LaunchedEffect(key1 = Unit) {
//        viewModel.getData()
//    }
    Column(modifier = Modifier.padding(8.dp)){
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = "",
            onValueChange = {  },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Search")})
        Spacer(modifier = Modifier.padding(5.dp))
        LazyColumn {
            items(viewModel.state.value){ city ->
                CityDetails(city = city){
                    onClick(city)
                }
            }

        }
    }
}


@Composable
fun CityDetails(city:City, onClick:() -> Unit){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(100.dp)
        .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)) {
        Column (modifier = Modifier.padding(8.dp)){
            Row {
                Text(text = "${city.name.toString()},", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = city.country.toString(), style = MaterialTheme.typography.titleMedium)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row {
                Text(text = city.coord?.lon.toString(),style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = city.coord?.lat.toString(),style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomePreview(){
//    HomeScreen(
//        listOf(
//            City("EGY", name = "Cairo", coord = Coord("55555555", "101010101")),
//            City("EGY", name = "Cairo", coord = Coord("5555555", "101010101")),
//            City("EGY", name = "Cairo", coord = Coord("777777", "101010101")),
//            City("EGY", name = "Cairo", coord = Coord("8888888", "101010101")),
//            City("EGY", name = "Cairo", coord = Coord("5555555", "101010101"))
//        )
//    )
//}
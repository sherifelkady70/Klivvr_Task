package com.route.cities.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.route.cities.data.models.City

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClick: (City) -> Unit){
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val searchText by viewModel.searchQuery.collectAsState()
    var text by remember {
        mutableStateOf(searchText)
    }
    var active by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(8.dp)){
        Spacer(modifier = Modifier.padding(10.dp))

        SearchBar(query = text,
            onQueryChange = {text = it},
            onSearch = {viewModel.searchAlgorithm(text)},
            active = active,
            onActiveChange = {active=it} ,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text="Search")
            } ,
            leadingIcon = {
                Icon(imageVector =Icons.Default.Search , contentDescription = "Search Icon")
            },
            trailingIcon = {
                if (active) {
                    Icon(modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            active = false
                        }
                    }, imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                }
            }){
            LazyColumn {
                items(viewModel.filteredList.value) { city ->
                    CityDetails(city = city) {
                        onClick(city)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        LazyColumn {
            items(viewModel.cities.value.data){ city ->
                CityDetails(city = city){
                    onClick(city)
                }
            }
            item { Button(onClick = { viewModel.loadNextPage() }) {
                Text(text = "Load More")
            } }
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
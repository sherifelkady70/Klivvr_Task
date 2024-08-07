# Klivvr_Task
The task is the presentation of a group of cities around the world and when every city is pressed, the location of this city is displayed on Google Mab

# The first add cities.json file to asset folder
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/json%20in%20asset.png" alt="Image 1" width="600" height="450"></td>
  </tr>
</table>

# The second create models and stable the design
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/Design.png" alt="Image 1" width="600" height="450"></td>
  </tr>
</table>

# The third define the flow of data 
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/Data%20Flow.png" alt="Image 1" width="600" height="450"></td>
  </tr>
</table>

# The technologies that used until this step 
* **Technologies:**
     * Kotlin.
     * Jetpack Compose.
     * MVVM.
     * Repository Pattern.
     * Dagger-Hilt.
     * Coroutines.
 
video of app for this step only.
[video](https://drive.google.com/file/d/1uQujkG7FLDLDmD2zaIxq5nYTZFbmglMg/view?usp=drive_link)

# Make location funtion
display google maps by Intent object (messaging ibject) , used standard action Intent.ACTION_VIEW to tell the system i want to view something
use geographical location by latitude and longitude given in json file
use intent.setPackage("com.google.android.apps.maps") to ensure the intent opens google maps specifically
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/locatoin%20function.png" alt="Image 1" width="600" height="450"></td>
  </tr>
</table>

# create NetworkChecker object to check conncetivity by Connectivity Manager class and Network Capabilities
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/network%20check.png" alt="Image 1" width="600" height="450"></td>
  </tr>
</table>

# image of app
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/cities%20app%20image.jpg" alt="Image 1" width="300" height="450"></td>
  </tr>
</table>

video of app for second step only.
[video](https://drive.google.com/file/d/1p_HvMGkx8UrLcyxHUERvjHQFDKb6YBHi/view?usp=drive_link)

# Implementation of search functionality
First make class and data class for Trie data structure .
Trie : is good for store and retrieve the dynamic set of Strings or Keys and for searching for strings with common prefix.
each node represents the single character of the string and The structure of the Trie is organized such that each path from a root node to the leaf node an end of the word node.
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/Trie%20Node.png" alt="Image 1" width="300" height="300"></td>
  </tr>
</table>
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/Trie%20class.png" alt="Image 1" width="300" height="300"></td>
  </tr>
</table>

Make buildTrie Method to build trie for cities list and insert each word of city name in root .
searchAlgoritm method to get the right prefix from user and filter the list based on it .
then after get prefix string from user and filter list store new filtered list (results) in mutable state list to display in body of search bar.
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/searchAlgorithm%20and%20buildTrie.png" alt="Image 1" width="300" height="300"></td>
  </tr>
</table>

searchCities method take prefix string from user and collect char and make searchAlgorithm on it .
then take results list.
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/serachCities%20Method.png" alt="Image 1" width="300" height="300"></td>
  </tr>
</table>

video of app after all thing without pagination or divide the data.
[video](https://drive.google.com/file/d/1PrLHleP5ZMqgbXnKzC-HO0tVcp21vox0/view?usp=drive_link)

# Add pagination
first add pagination data class that have pagination informations and pagination method in CitiesDataManager.
the getCitiesForPage method divides the all Cities list into pages based on the specified page size and returns a PaginatedData object containing the current page's data, page number, page size, and total page count.
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/pagination%20data%20class.png" alt="Image 1" width="300" height="300"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/pagination%20method.png" alt="Image 1" width="300" height="300"></td>
</table>

in view model add loadNextPage method to load more data by page size .
and i bind this method to button to load more if need.
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/laod%20next%20page%20method.png" alt="Image 1" width="300" height="300"></td>
</table>
# Last images of App
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/start.jpg" alt="Image 1" width="200" height="350"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/2.jpg" alt="Image 2" width="200" height="350"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/3.jpg" alt="Image 1" width="200" height="350"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/IMG-20240807-WA0003.jpg" alt="Image 2" width="200" height="350"></td>
  </tr>
</table>
<table>
  <tr>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/IMG-20240807-WA0006.jpg" alt="Image 1" width="200" height="350"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/IMG-20240807-WA0007.jpg" alt="Image 2" width="200" height="350"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/IMG-20240807-WA0008.jpg" alt="Image 1" width="200" height="350"></td>
    <td><img src="https://github.com/sherifelkady70/Klivvr_Task/blob/master/end.jpg" alt="Image 2" width="200" height="350"></td>
  </tr>
</table>

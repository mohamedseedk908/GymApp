package com.ms.gymsapp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ms.gymsapp.ui.theme.Purple40

@Composable
fun GymsScreen() {
    val vm : GymsViewModel = viewModel()
    LazyColumn () {
        items(vm.state.value){ gym ->
            ItemGym(gym = gym,{
                vm.toggleFavoriteState(it)
            })
        }
    }
}
@Composable
fun ItemGym(gym: Gym,onClick:(Int)-> Unit ) {
    val icon = if (gym.isFavorite)
    {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
    Card (
        elevation = CardDefaults.cardElevation(1.dp),

        modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
        Row (
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DefaultIcon(
                icon,
                modifier = Modifier.weight(0.15f),
                contentDescription = "Icon",
                )
            GymDetails(gym, modifier = Modifier.weight(0.70f))
            DefaultIcon(
                icon, modifier = Modifier.weight(0.15f),
                contentDescription = "Icon",{
                    onClick(gym.id)
                })
        }
    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier,
    contentDescription: String,
    onClick:()-> Unit = {},

) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier.padding(8.dp)
            .clickable{
                onClick()
            }

    )
}

@Composable
fun GymDetails(gym: Gym,modifier: Modifier) {
    Column (modifier = modifier){
        Text(
            text = gym.name,
            style = MaterialTheme.typography.bodyMedium,
            color = Purple40,
            )
        Text(
            text = gym.place,
            style = MaterialTheme.typography.bodyLarge,
            )
    }
}
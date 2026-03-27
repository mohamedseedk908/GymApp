package com.ms.gymsapp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ms.gymsapp.ui.theme.Purple40

@Composable
fun GymsScreen() {
    val vm : GymsViewModel = viewModel()
    LazyColumn () {
       items(vm.getGyms()) { it->
           ItemGym(it)
       }
    }
}
@Composable
fun ItemGym(gym: Gym) {
    Card (
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(Color.Gray),
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
        Row (
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GymIcon(Icons.Filled.Favorite, Modifier.weight(0.15f))
            Spacer(modifier = Modifier.width(10.dp))
            GymDetails(gym,Modifier.weight(0.85f))
        }
    }
}
@Composable
fun GymIcon(icon: ImageVector,modifier: Modifier) {
    Image(imageVector = icon, contentDescription = "Gym Icon Place")
}
@Composable
fun GymDetails(gym: Gym,modifier: Modifier) {
    Column {
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
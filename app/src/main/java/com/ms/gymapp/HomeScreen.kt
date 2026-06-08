package com.ms.gymapp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ms.gymapp.ui.theme.Purple40

@Composable
fun HomeScreen() {
    val vm: GymsViewModel = viewModel()
    LazyColumn () {
        items(vm.getGyms()) {it->
            GymItem(it)
        }
    }
}

@Composable
fun GymItem(gym: Gym) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            GymIcon(
                painter = painterResource(id = R.drawable.mohamed),
                Modifier.weight(0.20f)
                    .clip(CircleShape)
                    .border(width = 3.dp, color = Color.Yellow, shape = CircleShape)
            )
            GymDetails(Modifier.weight(0.80f), gym = gym)
        }
    }
}

@Composable
fun GymDetails(modifier: Modifier,gym: Gym) {
    Column (modifier = modifier ) {
        Text(
            text = gym.name,
            style = TextStyle(
                color = Purple40,
                fontSize = 25.sp,
            )
        )
        Text(
            text = "https://www.youtube.com/@MohamedSedyk",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun GymIcon(painter: Painter, modifier: Modifier) {
    Image(
        painter = painter,
        contentDescription = "IconGym",
        modifier = modifier,
        contentScale = ContentScale.Fit
    )

}

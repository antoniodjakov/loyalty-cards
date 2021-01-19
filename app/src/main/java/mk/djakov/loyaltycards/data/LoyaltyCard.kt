package mk.djakov.loyaltycards.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mk.djakov.loyaltycards.R
import mk.djakov.loyaltycards.ui.purple500

@Composable
fun CardsList(cards: List<Card>, onClick: (Card) -> Unit) {
    ScrollableColumn(
        Modifier.fillMaxSize()
            .padding(bottom = 52.dp)
    ) {
        cards.forEach { card ->
            LoyaltyCard(card) { onClick(it) }
        }
    }
}

@Composable
fun LoyaltyCard(card: Card, onClick: (Card) -> Unit) {
    androidx.compose.material.Card(
        elevation = 12.dp,
        modifier = Modifier.padding(8.dp)
            .clickable(onClick = {})
            .fillMaxWidth()
            .clickable(onClick = { onClick(card) })
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                imageResource(id = R.drawable.card_template),
                modifier = Modifier
                    .preferredHeight(80.dp)
                    .preferredWidth(80.dp)
                    .padding(4.dp)
            )
            Column {
                Text(text = card.name, style = MaterialTheme.typography.h4)
                Text(text = card.barcode, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = purple500,
        modifier = Modifier.preferredHeight(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FAB(onClick: () -> Unit) {
    FloatingActionButton(
        shape = CircleShape,
        onClick = { onClick },
    ) {
        Icon(imageVector = Icons.Filled.Add)
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(
        backgroundColor = purple500,
        cutoutShape = CircleShape,
        modifier = Modifier.preferredHeight(58.dp)
    ) {
        IconButton(onClick = {
//                    scaffoldState.drawerState.open()
        }) {
            Icon(Icons.Filled.Menu, tint = Color.White)
        }

//        Text(text = "BottomAppBar")

        Spacer(modifier = Modifier.preferredSize(16.dp))

        Button(
            onClick = { },
            modifier = Modifier.background(Color.Red)
        ) {
            Row() {
                Text("Button")
            }
        }
    }
}
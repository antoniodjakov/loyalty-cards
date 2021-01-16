package mk.djakov.loyaltycards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import mk.djakov.loyaltycards.data.Card
import mk.djakov.loyaltycards.ui.LoyaltyCardsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoyaltyCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoyaltyCards()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoyaltyCards()
}

@Composable
fun LoyaltyCards() {
    ScrollableColumn() {
        listOf(
            Card("Ramstore", "123", ""),
            Card("Vero", "123", ""),
            Card("MakPetrol", "123", ""),
            Card("Vero", "123", ""),
            Card("Vero", "123", ""),
            Card("Vero", "123", ""),
            Card("Ramstore", "123", "")
        ).forEach { card ->
            androidx.compose.material.Card(
                elevation = 12.dp,
                modifier = Modifier.padding(8.dp)
                    .clickable(onClick = {})
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        asset = imageResource(id = R.drawable.card_template),
                        modifier = Modifier
                            .preferredSize(80.dp, 80.dp)
                            .padding(4.dp)
                    )
                    Column {
                        Text(text = card.name, style = MaterialTheme.typography.h4)
                        Text(text = card.barcode, style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

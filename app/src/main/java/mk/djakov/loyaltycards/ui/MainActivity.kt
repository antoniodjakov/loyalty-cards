package mk.djakov.loyaltycards.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import mk.djakov.loyaltycards.data.CardDetails
import mk.djakov.loyaltycards.data.HomeScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoyaltyCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(applicationContext, viewModel) {
                        // onCardClick
                        //TODO display card details
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        HomeScreen(applicationContext, viewModel) {

        }
    }

}

package mk.djakov.loyaltycards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import mk.djakov.loyaltycards.data.BottomBar
import mk.djakov.loyaltycards.data.CardsList
import mk.djakov.loyaltycards.data.FAB
import mk.djakov.loyaltycards.data.TopBar
import mk.djakov.loyaltycards.extensions.visible
import mk.djakov.loyaltycards.ui.LoyaltyCardsTheme
import mk.djakov.loyaltycards.util.Data
import mk.djakov.loyaltycards.util.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoyaltyCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        HomeScreen()
    }

    @Composable
    fun HomeScreen() {
        ConstraintLayout() {
            val (body, progress) = createRefs()
            Scaffold(
                drawerContent = {
                    (1..10).forEach {
                        Text(text = "Row no.$it")
                    }
                },
                topBar = { TopBar() },
                floatingActionButton = {
                    FAB() {
                        //onClick

                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                isFloatingActionButtonDocked = true,
                bodyContent = {
                    CardsList(Data.cards) {
                        //onClick()
                        applicationContext.toast(it.name)
                    }
                },
                bottomBar = { BottomBar() }
            )
            CircularProgressIndicator(
                modifier = Modifier.constrainAs(progress) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.visible(false)
            )
        }
    }
}

package mk.djakov.loyaltycards.data

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import mk.djakov.loyaltycards.extensions.visible
import mk.djakov.loyaltycards.ui.MainViewModel
import mk.djakov.loyaltycards.util.toast

@Composable
fun HomeScreen(context: Context, viewModel: MainViewModel) {
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }
    val isLoading: Boolean by viewModel.isLoading.observeAsState(true)
    Column(
        // Make the column fill the whole screen space (width and height).
        modifier = Modifier.fillMaxSize(),
        // Place all children at center horizontally.
        horizontalAlignment = Alignment.CenterHorizontally,
        // Place all children at center vertically.
        verticalArrangement = Arrangement.Center
    ) {

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
                    FAB {
                        //onClick
                        setShowDialog(true)

                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                isFloatingActionButtonDocked = true,
                bodyContent = {
                    CardsList(viewModel = viewModel) {
                        //onClick()
                        context.toast(it.name)
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
                }.visible(isLoading)
            )
        }
        InsertCard(showDialog = showDialog, setShowDialog = setShowDialog)
    }
}
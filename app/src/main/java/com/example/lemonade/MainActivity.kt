package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import com.example.lemonade.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeImage(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    val imagesResources = when(result){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> {R.drawable.lemon_restart}
    }
    val textResourcesName = when(result){
        1 -> R.string.LemonTreeName
        2 -> R.string.LemonName
        3 -> R.string.GlassOfLemonadeName
        else -> R.string.EmptyGlassName
    }
    val textResources = when(result){
        1 -> R.string.LemonTree
        2 -> R.string.Lemon
        3 -> R.string.GlassOfLemonade
        else -> R.string.EmptyGlass
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = modifier.height(64.dp))
        Box(modifier = modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.05f)
            .clip(shape = RoundedCornerShape(14.dp))
            .background(Color.Yellow)) {
            Text(
                text = stringResource(id = textResourcesName),
                fontSize = 18.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically),
            )
        }
        val random = (2..4).random()
        var i = 0
        Spacer(modifier = modifier.height(200.dp))
        Image(
            painter = painterResource(id = imagesResources),
            contentDescription = result.toString(),
            modifier = modifier
                .clip(shape = RoundedCornerShape(14.dp))
                .background(GreenMint)
                .clickable {
                if (result == 2) {
                    i++
                    if (i > random) {
                        result++
                    }
                }else {
                    if (result == 4) result = 1
                    else result++
                }
            }

        )
        Spacer(modifier = modifier.height(16.dp))

        Text(text = stringResource(id = textResources),
            textAlign = TextAlign.Center,
            modifier = modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically)
        )

    }
}

@Composable
@Preview
fun LemonadeApp(){
    LemonadeImage(modifier = Modifier)

}


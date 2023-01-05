@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.marvel
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun HeroesPageScreen() {
    val heroList = HeroListConstant.heroList
    val colorList: List<Color> = listOf(Color.Blue, Color.Red, Color.LightGray, Color.Cyan, Color.Red)
    val pagerState = rememberPagerState()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = R.drawable.marvel),
            modifier = Modifier.height(65.dp),
            contentDescription = "Marvel Logo")

        Text("Choose your hero", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
        HorizontalPager(count = heroList.size, state = pagerState, modifier = Modifier.drawBehind {
            val path = Path().apply {
                moveTo(size.width, 0f)
                lineTo(x = size.width, y = size.height)
                lineTo(x = 0f, y = size.height)
            }

            drawPath(
                path = path,
                colorList[pagerState.currentPage],
            )
        })
        {
                page: Int -> Card(modifier = Modifier.graphicsLayer {
            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
            lerp(
                start = 0.64f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f)
            ).also { scale ->
                scaleX = scale
                scaleY = scale
            }


            alpha = lerp(
                start = 0.5f,
                stop = 1f,
                fraction = 1f - pageOffset.coerceIn(0f, 1f)
            )
        }.padding(16.dp), shape = RoundedCornerShape(50.dp), ){ HeroCard(hero = heroList[page])}


        }
    }
}


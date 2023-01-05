package com.example.marvel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HeroesPageScreen() {
    val heroList = HeroListConstant.heroList;
    var pagerState = rememberPagerState();
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = R.drawable.marvel),
            modifier = Modifier.height(65.dp),
            contentDescription = "Marvel Logo")
        Text("Choose your hero", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        HorizontalPager(count = heroList.size, state = pagerState)
        {
                page: Int -> HeroCard(hero = heroList[page])

        }
    }
}
package com.example.marvel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeroCard(hero: HeroMarvel) {
    val heroName = hero.name;
    val heroId = hero.resId;

    Card(modifier = Modifier.fillMaxSize() .padding(16.dp), shape = RoundedCornerShape(50.dp),)
    {

        Image(painter = painterResource(id = heroId), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            )
        Box(modifier =  Modifier.fillMaxSize().padding (start = 30.dp, bottom = 20.dp), contentAlignment = Alignment.BottomStart)
        {
            Text(heroName, textAlign = TextAlign.Center, color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }

    }
}
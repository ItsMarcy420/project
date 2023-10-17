package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
// ++

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            startScreen()
        }
    }
}

@Composable

fun startScreen() {
    var clicked by remember { mutableStateOf(false) }
    //A bool that restart every times
    var fadeInAni by remember { mutableStateOf(false) }

    // animation controller
    val fadeInAlpha = if(fadeInAni) 1f else 0f
    // the opacity about animation
    val fadeInModifier = Modifier.alpha(fadeInAlpha)
    // a compose modifier
    val fadeInSec = tween<Float>(durationMillis = 1000, easing = LinearEasing)
    // animation speed

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                if(!clicked){fadeInAni =!fadeInAni }else{}
                clicked =! clicked
            },
        contentAlignment = Alignment.Center
    ){
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            // Replace with your image resource
            contentDescription = null, // Provide content description if needed
            modifier = Modifier.fillMaxSize()
        )
        Column(
            // A box to place the content
            modifier = Modifier // to change column's feature
                .fillMaxSize()
                .background(Color.White)
                .clickable { //trigger
                    clicked = !clicked
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // inside the column what content to place
            Text(
                text = if (clicked) "" else "TITLE", fontSize = 40.sp, color = Color.Cyan
            )
            Spacer(modifier = Modifier.height(16.dp))
            // like manual margin
            Text(
                text = if (clicked) "LOADING..." else "~Touch to Start~",
                fontSize = 24.sp,
                color = if (clicked) Color.Gray else Color.Blue,
                modifier = Modifier.clickable {
                    // Trigger the game transition here
                    // For example, start a new activity or change the game state
                }


            )
        }
    }
}


//@Preview(showBackground = true)

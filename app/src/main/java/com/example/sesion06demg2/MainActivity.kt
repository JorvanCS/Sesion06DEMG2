package com.example.sesion06demg2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sesion06demg2.ui.theme.Sesion06DEMG2Theme
import com.example.sesion06demg2.views.PrincipalUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesion06DEMG2Theme {
                PrincipalUI()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sesion06DEMG2Theme {

    }
}
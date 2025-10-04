package com.android.myappnative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.myappnative.ui.screens.ArbolScreen
import com.android.myappnative.ui.theme.MyAppNativeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppNativeTheme {

                    ArbolScreen()

            }
        }
    }
}


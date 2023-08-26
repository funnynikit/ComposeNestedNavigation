package com.demo.nestednavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.demo.nestednavigation.graphs.RootNavigationGraph
import com.demo.nestednavigation.ui.theme.NestedNavigationBottomBarDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedNavigationBottomBarDemoTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
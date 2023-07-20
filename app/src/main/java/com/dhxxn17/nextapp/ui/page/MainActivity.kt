package com.dhxxn17.nextapp.ui.page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dhxxn17.nextapp.ui.Screens
import com.dhxxn17.nextapp.ui.theme.NextAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextAppTheme {
                NextApp()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NextApp() {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { _innerPadding ->
            Box(
                modifier = Modifier.padding(_innerPadding)
            ) {
                NavigationGraph(navController = navController)
            }
        }
    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Screens.IntroScreen.route) {
            composable(Screens.IntroScreen.route) {
                IntroScreen(navController)
            }
            composable(Screens.ListScreen.route) {
                ListScreen(navController)
            }
            composable(Screens.OrderScreen.route) {
                OrderScreen(navController)
            }
            composable(Screens.CompleteScreen.route) {
                CompleteScreen(navController)
            }
        }
    }
}


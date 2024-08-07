package edu.miu.repositorypattern

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.miu.navdatatransfer.ui.navigations.App
import edu.miu.repositorypattern.ui.components.TopBar
import edu.miu.repositorypattern.ui.theme.RepositoryPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepositoryPatternTheme {
                val navHostController: NavHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar(navController = navHostController)}
                ) { innerPadding ->
                    App(navHostController, Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    RepositoryPatternTheme {
        val navHostController: NavHostController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(navController = navHostController)}
        ) { innerPadding ->
            App(navHostController, Modifier.padding(innerPadding))
        }
    }
}
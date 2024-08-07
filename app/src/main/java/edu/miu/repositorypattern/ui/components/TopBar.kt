package edu.miu.repositorypattern.ui.components

import android.os.Bundle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController) {
    var canNavigateBack by remember {
        mutableStateOf(false)
    }
    navController.addOnDestinationChangedListener {
            controller, destination, arguments ->
            canNavigateBack = navController.currentDestination?.route != "screen-1"
    }
    TopAppBar(
        title = {
            Text(text = "Simple Navigation Demo")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            val navIcon = if (canNavigateBack) Icons.AutoMirrored.Filled.ArrowBack else Icons.Filled.Home
            IconButton(onClick = { if (canNavigateBack) navController.navigateUp() else navController.navigate("home") }) {
                Icon(navIcon, contentDescription = "Nav Icon")
            }
        }
    )
}
class MyOnDestinationChangedListener: NavController.OnDestinationChangedListener {
    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        TODO("Not yet implemented")
    }

}
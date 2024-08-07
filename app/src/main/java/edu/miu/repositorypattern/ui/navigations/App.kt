package edu.miu.navdatatransfer.ui.navigations


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.miu.navdatatransfer.ui.screens.ScreenOne
import edu.miu.navdatatransfer.ui.screens.ScreenThree
import edu.miu.navdatatransfer.ui.screens.ScreenTwo

@Composable
fun App(navHostController: NavHostController, modifier: Modifier = Modifier) {
    //create NavHost
    NavHost(navController = navHostController, startDestination = "screen-1") {
        composable("screen-1") {
            ScreenOne(navController = navHostController, modifier = modifier)
        }
        composable("screen-2/{data}") {
            // Retrieve the data from the arguments,
            // or use a default value if not available
            val data = it.arguments?.getString("data")?: "No data available"
            // Store the data in the current back stack entry's arguments
            navHostController.currentBackStackEntry?.arguments?.apply {
                putString("data", data)
            }
            ScreenTwo(navController = navHostController, modifier = modifier)
        }
//        composable("screen-3/{data2}") {
        composable("screen-3/{regNo}") {
            /*// Retrieve the data from the arguments,
            // or use a default value if not available
            val data = it.arguments?.getString("data2")?: "[]"
            // Store the data in the current back stack entry's arguments
            navHostController.currentBackStackEntry?.arguments?.apply {
                putString("data", data)
            }*/
            val regNo = it.arguments?.getString("regNo")?: "unKnown"
            navHostController.currentBackStackEntry?.arguments?.apply {
                putString("regNo", regNo)
            }
            ScreenThree(navController = navHostController, modifier = modifier)
        }
    }
}

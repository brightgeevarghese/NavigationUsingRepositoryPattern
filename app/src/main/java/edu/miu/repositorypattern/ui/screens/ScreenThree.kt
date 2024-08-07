package edu.miu.navdatatransfer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavController
import edu.miu.navdatatransfer.data.Student
import edu.miu.repositorypattern.MyApplication
import kotlinx.serialization.json.Json

@Composable
fun ScreenThree(navController: NavController, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication
    //Fetch repository from application context
    val repository = myApplication.getRepository()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go to Previous")
        }

        //Fetch the data from the current back stack entry's arguments
        val regNo = navController.currentBackStackEntry?.arguments?.getString("regNo")?: "unKnown"
        val student = repository.getStudent(regNo)
        Text(text = "Screen Three: $student")

        Button(onClick = { navController.popBackStack(navController.graph.startDestinationId, false) }) {
            Text(text = "Go to Home")
        }
    }
}
package uz.itschool.mathkidsnew.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.itschool.mathkidsnew.screens.homescreen.HomeScreen
import uz.itschool.mathkidsnew.screens.menuscreen.MenuScreen
import uz.itschool.mathkidsnew.screens.questionscreen.QuestionScreen
import uz.itschool.mathkidsnew.screens.splashscreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    )
    {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.Menu.route) {
            MenuScreen(navController)
        }
        composable(route = Screens.Questions.route) {
            QuestionScreen(navController)
        }
    }
}
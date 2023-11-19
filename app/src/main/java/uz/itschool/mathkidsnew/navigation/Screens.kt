package uz.itschool.mathkidsnew.navigation

sealed class Screens(val route: String) {
    object Splash: Screens("splash_screen")
    object Home: Screens("home_screen")
    object Menu: Screens("menu_screen")
    object Questions: Screens("question_screen")
}
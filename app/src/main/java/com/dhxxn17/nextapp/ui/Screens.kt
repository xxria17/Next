package com.dhxxn17.nextapp.ui

sealed class Screens(
    val route: String
) {
    object IntroScreen: Screens("intro_screen")

    object ListScreen: Screens("list_screen")

    object OrderScreen: Screens("order_screen")

    object CompleteScreen: Screens("complete_screen")
}

package com.twugteam.admin.day1

sealed class NavRoute (val route:String) {
    object LoginScreen:NavRoute("login")
    object HomeScreen:NavRoute("home")
    object MenuScreen:NavRoute("menu")
}
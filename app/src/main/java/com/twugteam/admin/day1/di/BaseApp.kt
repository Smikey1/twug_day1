package com.twugteam.admin.day1.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// External Class  -->// Holds the object of Other class
//class BaseApp {
//
//    // Holds the object of Other class
//    val i5=Chip()
//    val process:Processor = Processor(i5)
//    val powerSupply=PowerSupply()
//    val computer = Computer(process,powerSupply)
////    val computer = Computer(process,PowerSupply())
//}

@HiltAndroidApp
class BaseApp:Application() {

    // compile time --> run click
}
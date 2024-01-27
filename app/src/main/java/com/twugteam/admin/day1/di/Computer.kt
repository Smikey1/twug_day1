package com.twugteam.admin.day1.di

import javax.inject.Inject

class Computer @Inject constructor(private val i5:Processor, private val powerSupply:PowerSupply) {
    fun getStarted(){
        i5.connect()
        println("Computer Started")
    }
}


open class Processor @Inject constructor(private val ic:Chip) {
    open fun connect(){
        ic.initialize()
        println("Processor Connected")
    }
}

open class Chip @Inject constructor(){
    fun initialize(){
        println("Chip Initialized")
    }
}

class PowerSupply @Inject constructor(){

}


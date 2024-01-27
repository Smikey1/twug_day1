package com.twugteam.admin.day1.di

class Computer(private val i5:Processor, private val powerSupply:PowerSupply) {
    fun getStarted(){
        i5.connect()
        println("Computer Started")
    }
}


open class Processor(private val ic:Chip) {
    open fun connect(){
        ic.initialize()
        println("Processor Connected")
    }
}

open class Chip(){
    fun initialize(){
        println("Chip Initialized")
    }
}

class PowerSupply{

}
package com.twugteam.admin.day1.di

// External Class
class BaseApp {
    val i5=Chip()
    val process:Processor = Processor(i5)
    val powerSupply=PowerSupply()
    val computer = Computer(process,powerSupply)
//    val computer = Computer(process,PowerSupply())
}
package com.example.thunderclouds

abstract class City {

    abstract val title: String


}

class Minsk : City() {


    override val title: String
        get() = TODO("Not yet implemented")
}



class Forecast<out T : City>(city: T) {

}


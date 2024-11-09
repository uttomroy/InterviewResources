package com.lld.elevator

open class Button {
    open fun pressButton(picupFloor: Int, direction: Direction) : Unit {
        println("button is pressed")
    }

    open fun pressButton(destinationFloor: Int, elevatorId: Int) : Unit {
        println("button is pressed $destinationFloor elevator: $elevatorId")
    }
}
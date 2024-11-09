package com.lld.elevator

class Floor (val id: Int) {
    private val button: ExternalButton = ExternalButton()

    fun pressButton(direction: Direction){
        button.pressButton(id, direction)
    }
}
package com.lld.elevator

class InternalButton : Button() {
    override fun pressButton(destinationFloor: Int, elevatorId: Int) {
       InternalDispatcher.assignDestinationFloor(destinationFloor, elevatorId)
    }
}
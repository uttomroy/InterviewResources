package com.lld.elevator

object InternalDispatcher {
    fun assignDestinationFloor(destinationFloor: Int, elevatorId: Int){
        ElevatorSystem.elevators.find { it.elevatorId == elevatorId }!!.addRequestFromElevatorInside(destinationFloor)
    }
}
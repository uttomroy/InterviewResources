package com.lld.elevator

object ElevatorSystem {
    val elevators: List<Elevator> = listOf(Elevator(1))
    val floors: List<Floor> = listOf(Floor(1), Floor(2), Floor(3))

    fun prepareElevatorToServeRequest(){
       for(elevator in elevators){
           Thread{
               elevator.run()
           }.start()
       }
    }

    fun requestForElevator(currentFloor: Int, direction: Direction){
        floors.find { it.id == currentFloor }!!.pressButton(direction)
    }

    fun requestForDestinationFloor(destinationFloor: Int){
        elevators.first().pressDestinationFloor(destinationFloor)
    }
}
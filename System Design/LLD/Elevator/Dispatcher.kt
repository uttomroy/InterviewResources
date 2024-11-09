package com.lld.elevator

object Dispatcher {

    private val elevators = ElevatorSystem.elevators

    @Synchronized
    fun assignPendingRequest(request: Request) {
         getElevatorToServeTheRequest(request.currentFloor, request.direction).addRequestFromFloor(request)
    }

    private fun getElevatorToServeTheRequest(floorId: Int, direction: Direction): Elevator {
        if(direction == Direction.UP && getAnyElevatorWhichIsGoingUp(floorId) != null)
            return getAnyElevatorWhichIsGoingUp(floorId)!!
        else if(direction == Direction.UP && getAnyElevatorWhichIsGoingDown(floorId) != null)
            return getAnyElevatorWhichIsGoingDown(floorId)!!
        else return getRandomElevatorWhichIsClosest(floorId)
    }

    private fun getAnyElevatorWhichIsGoingUp(floorId: Int): Elevator? {
        for(elevator in elevators) {
            if(elevator.direction == Direction.UP && elevator.currentFloorId < floorId){
                return elevator
            }
        }
        return null
    }

    private fun getAnyElevatorWhichIsGoingDown(floorId: Int): Elevator? {
        for(elevator in elevators) {
            if(elevator.direction == Direction.DOWN && elevator.currentFloorId >= floorId){
                return elevator
            }
        }
        return null
    }

    private fun getRandomElevatorWhichIsClosest(floorId: Int): Elevator{
        // first check the closest idle or that can pick him/her on the same direction
        // otherwise take the random closest ones

        return elevators.first()
    }
}
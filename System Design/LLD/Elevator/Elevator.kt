package com.lld.elevator

import java.util.*

class Elevator (val elevatorId: Int) {
    var currentFloorId: Int = 1
    private val pendingInRequest : MutableList<Request> = Collections.synchronizedList(mutableListOf())
    private val pendingOutRequest : MutableList<Int> = Collections.synchronizedList(mutableListOf())
    private val button: InternalButton = InternalButton()
    var direction: Direction = Direction.NONE


    fun addRequestFromFloor(request: Request) {
        println(request.currentFloor)
        pendingInRequest.add(request)
    }

    fun addRequestFromElevatorInside(destinationFloor: Int) {
        pendingOutRequest.add(destinationFloor)
    }

    fun pressDestinationFloor(floor: Int) {
        println("destination floor: $floor current: $currentFloorId")
        button.pressButton(floor, elevatorId)
    }

    private fun move(){
        println("Reqeust is processing for elevator $elevatorId")
        while(true){
            if(isAnyPendingRequest()){
                doneAllRequestOfThisFloor(currentFloorId)
                if(isAnyPendingRequest()){
                    println("$currentFloorId")
                    if(direction == Direction.UP && (isAnyoneWaitingToGoUp() || isAnyoneToStopUp())){
                        moveUp()
                    }else if(direction == Direction.DOWN && (isAnyoneWaitingToGoDown( ) || isAnyoneWaitingToStopDown())) {
                        moveDown()
                    }
                    else if(direction == Direction.UP){
                        moveDown()
                    }
                    else if(direction == Direction.DOWN){
                        moveUp()
                    }
                    else {
                        direction = Direction.UP
                    }
                }
            }
            else if(direction != Direction.NONE){
                direction = Direction.NONE
            }
        }
    }

    private fun moveUp(){
        println("current floor $currentFloorId")
        currentFloorId += 1
    }

    private fun moveDown(){
        currentFloorId -= 1
    }

    private fun doneAllRequestOfThisFloor(floor: Int){
       // if(floor == 3 )println("Request is being process for elevator $elevatorId floor $floor")
        pendingInRequest.removeAll{
            it.currentFloor == floor
        }
        pendingOutRequest.removeAll{
            it == floor
        }
    }

    private fun isAnyoneWaitingToGoUp() : Boolean
    {
        synchronized(pendingInRequest) {
            return pendingInRequest.any{
                it.direction == Direction.UP && it.currentFloor >= currentFloorId
            }
        }
    }

    private fun isAnyoneToStopUp() : Boolean
    {
        synchronized(pendingOutRequest){
            return pendingOutRequest.any{
                it >= currentFloorId
            }
        }
    }

    private fun isAnyoneWaitingToStopDown() : Boolean
    {
        synchronized(pendingOutRequest) {
            return pendingOutRequest.any{
                it <= currentFloorId
            }
        }
    }

    private fun isAnyoneWaitingToGoDown() : Boolean
    {
        synchronized(pendingInRequest){
            return pendingInRequest.any{
                it.direction == Direction.DOWN && it.currentFloor <= currentFloorId
            }
        }
    }

    private fun isAnyPendingRequest(): Boolean{
        return pendingInRequest.isNotEmpty() || pendingOutRequest.isNotEmpty()
    }

    fun run(){
        move()
    }
}
package com.lld.elevator

class ExternalButton : Button() {
    override fun pressButton(picupFloor: Int, direction: Direction) {
        Dispatcher.assignPendingRequest(Request(picupFloor, direction))
    }
}
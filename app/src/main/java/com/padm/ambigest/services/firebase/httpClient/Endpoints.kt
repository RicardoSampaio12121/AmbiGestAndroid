package com.padm.ambigest.services.firebase.httpClient

//TODO: Change the ip to whatever ip it will be hosted at
enum class Endpoints(val label: String) {
    GET_WATER_READINGS("http://192.168.1.73:3000/waterReadings/getAllByUserId/fdsfdsfdsfsd"),
    GET_PICKUP_ORDERS("http://192.168.1.73:3000/events/getEventsByUserId/6496d6a1c93ebf22eef6474f"),
    GET_USER_INFO("")
}
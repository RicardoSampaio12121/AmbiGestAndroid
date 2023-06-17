package com.padm.ambigest.services.firebase.httpClient.Models

import java.util.*

//TODO: Change this to whatever is coming from the back-end
data class PickupModel(val id: String,
                             val userId: String,
                             val contractId: String,
                             val amount: Float,
                             val createdAt: Date,
                             val updatedAt: Date
)

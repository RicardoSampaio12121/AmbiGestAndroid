package com.padm.ambigest.services.firebase.httpClient.Models

import java.util.*

data class WaterReadingModel(val id: String,
                             val userId: String,
                             val contractId: String,
                             val amount: Float,
                             val createdAt: Date,
                             val updatedAt: Date)

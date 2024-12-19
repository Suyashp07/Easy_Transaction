package com.example.bankingappupi.data

import androidx.compose.ui.graphics.Brush

data class Cards(
    var cardType: String,
    var cardNumber: String,
    var cardName: String,
    val balance: Double,
    var color: Brush


)
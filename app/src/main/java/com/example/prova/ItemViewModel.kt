package com.example.prova

import com.google.gson.annotations.SerializedName

class ItemViewModel (
    @SerializedName("name")
    val itemName: String,
    @SerializedName("image")
    val itemImageUrl: String,
    @SerializedName("details")
    val itemDetail: String
)
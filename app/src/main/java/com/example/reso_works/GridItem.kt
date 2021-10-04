package com.example.reso_works

data class GridItem (

    val title: String?,
    val desc : String,
    val image : String = "ico1.png",
    var isVisible : Boolean = false
)
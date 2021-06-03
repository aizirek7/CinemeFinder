package com.example.cinemafinder.model

import android.widget.ImageView
import android.widget.TextView

class Movie(
    var image: Int,
    var title: String,
    var date: String) {

    var rate: String = "2.4"

    constructor(image: Int, title: String, date: String, _rate: String): this(image, title, date){
        rate = _rate
    }
}
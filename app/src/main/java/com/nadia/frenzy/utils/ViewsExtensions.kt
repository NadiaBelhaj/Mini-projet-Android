package com.nadia.frenzy.utils

//Widget refers to the elements of the UI (User Interface) that helps user interacts with the Android App.
// TextView is one of many such widgets which can be used to improve the UI of the app.
/*Context It allows access to application-specific resources and classes, as well as up-calls for
application-level operations such as launching activities, broadcasting and receiving intents, etc.*/
//ContextCompat Helper for accessing features in Context.
//picasso simplifies the process of displaying images from internal storage or from an external URL.

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.nadia.frenzy.data.API_SERVER_URL
import com.squareup.picasso.Picasso

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun TextView.setTextOrGone(text: String?) {
    if (text.isNullOrEmpty()) {
        this.gone()
    } else {
        this.text = text
    }
}

fun TextView.setTextOrHide(text: String?) {
    if (text.isNullOrEmpty()) {
        this.hide()
    } else {
        this.text = text
    }
}

fun TextView.setFormattedJoinDate(time : Long) {
    this.text = "Joined in ${formatDateForJoin(time)}"
}

fun TextView.setFormattedDateForPost(time : Long) {
    this.text = formatDateForPost(time)
}

fun ImageView.loadImage(imageUrl: String?, defaultDrawableId : Int) {
    if(imageUrl.isNullOrEmpty()) return
    val imagePath = API_SERVER_URL + imageUrl.replace("\\", "/")
    Picasso.get()
        .load(imagePath)
        .error(defaultDrawableId).into(this)
}

fun CardView.backgroundColor(context : Context, @ColorRes colorId : Int){
    this.setCardBackgroundColor(ContextCompat.getColor(context, colorId))
}

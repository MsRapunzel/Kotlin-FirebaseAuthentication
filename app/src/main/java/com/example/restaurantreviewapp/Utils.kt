package com.example.restaurantreviewapp

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.snackbar.Snackbar


class Utils {

    companion object {
        fun displayMessage(view: View, msgText: String) {
            val sb = Snackbar.make(view, msgText, Snackbar.LENGTH_SHORT)
            sb.show()
        }
    }
}
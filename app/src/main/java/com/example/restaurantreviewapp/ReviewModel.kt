package com.example.restaurantreviewapp

import com.google.android.gms.maps.model.LatLng

class ReviewModel {

    private var id: String? = null
    private var uid: String? = null
    private var title: String? = null
    private var description: String? = null
    private var images: List<String>? = null
    private var location: LatLng? = null

    constructor(id: String?, uid: String?, title: String?, description: String?, images: List<String>?, location: LatLng?) {
        this.id = id
        this.uid = uid
        this.title = title
        this.description = description
        this.images = images
        this.location = location
    }

    fun create(id: String) {
        // Use Firebase Realtime Database to add the note object
    }

    fun read(id: String) {
        // Use Firebase Realtime Database to retrieve all notes
    }

    fun update(uid: String) {
        // Use Firebase Realtime Database to update the note object
    }

    fun delete(id: String) {
        // Use Firebase Realtime Database to remove the note object
    }
}


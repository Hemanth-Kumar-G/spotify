package com.hemanth.spotify.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.hemanth.spotify.common.Constants
import com.hemanth.spotify.data.model.Song
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val fireStore = FirebaseFirestore.getInstance()

    private val songCollection = fireStore.collection(Constants.SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> = try {
        songCollection.get().await().toObjects(Song::class.java)
    } catch (e: Exception) {
        emptyList()
    }

}



package com.example.android.databinding.basicsample.data

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt


/**
 * A simple VM for [com.example.android.databinding.basicsample.ui.PlainOldActivity].
 */
class SimpleViewModel : ViewModel() {
    val name = "Frank"
    val lastName = "Darwin"
    val likes = ObservableInt()
    val popularity = ObservableField<Popularity>(Popularity.NORMAL)

    /**
     * Increments the number of likes.
     */
    fun onLike() {
        likes.set(likes.get() + 1)

        popularity.set(likes.get().let {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        })
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}
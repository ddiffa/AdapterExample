package dev.hellodiffa.recyclerviewadapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val username : String,
    val address : String
) : Parcelable
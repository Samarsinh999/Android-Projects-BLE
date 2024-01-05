package com.example.rssivalidation

import android.location.Location
import androidx.annotation.DrawableRes

data class RideGridUserDetails(
@DrawableRes
val imageRes: Int,
val name: String,
val macAddress: String,
val distance: Int,
val nodeId: Int,
val directChild: Boolean,
val bearing: Int,
val location: Location
) {

}

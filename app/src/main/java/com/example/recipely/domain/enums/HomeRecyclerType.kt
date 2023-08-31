package com.example.recipely.domain.enums

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class HomeRecyclerType : Parcelable {
    HOME_POPULAR_TYPE,
    HOME_EDITORS_TYPE
}
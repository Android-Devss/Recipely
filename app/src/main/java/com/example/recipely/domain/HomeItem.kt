package com.example.recipely.domain

import com.example.recipely.domain.enums.HomeItemType

data class HomeItem
<T>(
    val item: T,
    val type: HomeItemType
)

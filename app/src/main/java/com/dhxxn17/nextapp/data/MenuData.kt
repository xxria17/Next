package com.dhxxn17.nextapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuData(
    val name: String,
    val price: Int,
    val category: Category,
    val isHot: Boolean?,
    val isDecaffein: Boolean?
) : Parcelable

enum class Category(val order: Int) {
    COFFEE(1),
    BEVERAGE(2),
    TEA(3),
    DESSERT(4)
}
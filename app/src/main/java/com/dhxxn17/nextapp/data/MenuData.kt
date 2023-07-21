package com.dhxxn17.nextapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuData(
    val name: String,
    val price: Int,
    val category: Category,
    val isHot: IS_HOT,
    val isDecaffein: IS_DECAFFEIN,
    val iceAmount: ICE_AMOUNT = ICE_AMOUNT.CANT_CHOOSE
) : Parcelable

enum class Category(val order: Int) {
    COFFEE(1),
    BEVERAGE(2),
    TEA(3),
    DESSERT(4)
}
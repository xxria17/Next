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

enum class IS_HOT {
    CANT_CHOOSE,
    HOT,
    COLD,
    NONE
}

enum class IS_DECAFFEIN(
    val title: String
) {
    CANT_CHOOSE("선택불가"),
    CAFFEIN("카페인"),
    DECAFFEIN("디카페인"),
    NONE("미선택")
}

enum class ICE_AMOUNT(
    val title: String
) {
    CANT_CHOOSE("선택불가"),
    LESS("적게"),
    REGULAR("보통"),
    MANY("많이"),
    NONE("미선택")
}
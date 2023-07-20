package com.dhxxn17.nextapp.util

import com.dhxxn17.nextapp.data.Category
import java.text.DecimalFormat

fun transPriceFormat(price: Int): String {
    val dec = DecimalFormat("#,###")
    return "${dec.format(price)}원"
}

fun stringToCategory(category: String): Category {
    return when(category) {
        "Coffee" -> Category.COFFEE
        "Beverage" -> Category.BEVERAGE
        "Tea" -> Category.TEA
        "Dessert" -> Category.DESSERT
        else -> Category.COFFEE
    }
}
package com.dhxxn17.nextapp.data

data class MenuData(
    val name: String,
    val price: Int,
    val category: Category,
    val isHot: Boolean?,
    val isDecaffein: Boolean?
)

enum class Category(val order: Int) {
    COFFEE(1),
    BEVERAGE(2),
    TEA(3),
    DESSERT(4)
}
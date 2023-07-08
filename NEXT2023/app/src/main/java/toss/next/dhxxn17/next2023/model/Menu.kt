package toss.next.dhxxn17.next2023.model

data class Menu(
    val menu: String,
    val category: Category,
    val canHot: Boolean,
    val canDecaffein: Boolean,
    val price: Int
)

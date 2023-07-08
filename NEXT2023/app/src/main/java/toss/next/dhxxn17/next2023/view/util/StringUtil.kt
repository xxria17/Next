package toss.next.dhxxn17.next2023.view.util

import java.text.DecimalFormat

object StringUtil {

    fun getPriceFormat(price: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return "${decimalFormat.format(price)}원"
    }
}
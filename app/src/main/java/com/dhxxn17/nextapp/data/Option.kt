package com.dhxxn17.nextapp.data

interface Option

enum class IS_HOT: Option {
    CANT_CHOOSE,
    HOT,
    COLD,
    NONE
}

enum class IS_DECAFFEIN(
    val title: String
): Option {
    CANT_CHOOSE("선택불가"),
    CAFFEIN("카페인"),
    DECAFFEIN("디카페인"),
    NONE("미선택")
}

enum class ICE_AMOUNT(
    val title: String
): Option {
    CANT_CHOOSE("선택불가"),
    LESS("적게"),
    REGULAR("보통"),
    MANY("많이"),
    NONE("미선택")
}
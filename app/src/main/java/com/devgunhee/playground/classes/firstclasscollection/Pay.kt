package com.devgunhee.playground.classes.firstclasscollection

sealed class Pay (open val amount: Long) { abstract val type: Type }
data class KakaoPay(override val amount: Long) : Pay(amount) { override val type: Type = Type.KAKAO }
data class NaverPay(override val amount: Long) : Pay(amount) { override val type: Type = Type.NAVER }
data class TossPay(override val amount: Long) : Pay(amount) { override val type: Type = Type.TOSS }

enum class Type { KAKAO, NAVER, TOSS }
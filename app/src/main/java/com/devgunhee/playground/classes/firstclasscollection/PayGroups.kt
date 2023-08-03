package com.devgunhee.playground.classes.firstclasscollection

class PayGroup(private val pays: List<Pay>) {

    fun getPays(type: Type): List<Pay> =
        pays.filter { it.type == type }

    fun getPaysSum(type: Type): Long =
        pays.filter { it.type == type }
            .sumOf { it.amount }

    fun getPayGroupSum(): Long =
        pays.sumOf { it.amount }
}
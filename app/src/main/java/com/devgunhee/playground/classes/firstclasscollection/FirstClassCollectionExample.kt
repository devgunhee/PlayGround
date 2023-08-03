package com.devgunhee.playground.classes.firstclasscollection

class FirstClassCollectionExample {

    fun sampleUsages() {
        val payGroup = PayGroup(
            listOf(
                KakaoPay(1_000),
                TossPay(50_000),
                NaverPay(200),
                KakaoPay(3_000),
                TossPay(210_000),
                NaverPay(7_000)
            )
        )

        payGroup.getPays(Type.KAKAO)
        // Result >> [KakaoPay(amount=1000), KakaoPay(amount=3000)]

        payGroup.getPays(Type.NAVER)
        // Result >> [NaverPay(amount=200), NaverPay(amount=7000)]

        payGroup.getPays(Type.TOSS)
        // Result >> [TossPay(amount=50000), TossPay(amount=210000)]

        payGroup.getPaysSum(Type.KAKAO)
        // Result >> 4000

        payGroup.getPaysSum(Type.NAVER)
        // Result >> 7200

        payGroup.getPaysSum(Type.TOSS)
        // Result >> 260000

        payGroup.getPayGroupSum()
        // Result >> 271200
    }
}
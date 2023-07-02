package com.devgunhee.playground.classes.enumclass

class EnumExample {

    /**
     *  usage of
     *
     *  @sample com.devgunhee.playground.classes.enumclass.Direction
     */
    fun howToUseSimpleEnum() {
        Direction.valueOf("NORTH")
        Direction.values()
        Direction.NORTH.name // same with Direction.NORTH.toString()
        Direction.NORTH.ordinal

        /**
         * All enum classes implement the Comparable interface by default.
         * Constants in the enum class are defined in the natural order.
          */
        Direction.NORTH > Direction.EAST

        /**
         * you can use [when] without [else] branch.
         */
        val type: String = "type"
        val ordinal = when (Direction.valueOf(type)) {
            Direction.EAST -> { Direction.EAST.ordinal }
            Direction.NORTH -> { Direction.NORTH.ordinal }
            Direction.SOUTH -> { Direction.SOUTH.ordinal }
            Direction.WEST -> { Direction.WEST.ordinal }
        }
    }

    /**
     *  usage of
     *
     *  @sample com.devgunhee.playground.classes.enumclass.Color
     */
    fun howToUseEnumWithProperty() {
        Color.valueOf("RED")
        Color.values()
        Color.RED.name
        Color.RED.ordinal
        Color.RED.rgb
        setColor(Color.RED.rgb)
    }

    private fun setColor(color: Int) {
        // ... set Color
    }

    /**
     *  usage of
     *
     *  @sample com.devgunhee.playground.classes.enumclass.ProtocolState
     */
    fun howToUseAnonymousEnumClass() {
        ProtocolState.valueOf("WAITING")
        ProtocolState.values()
        ProtocolState.WAITING.name
        ProtocolState.WAITING.ordinal
        ProtocolState.WAITING.signal()
    }

    /**
     *  usage of
     *
     *  @sample com.devgunhee.playground.classes.enumclass.IntArithmetics
     */
    fun howToUseEnumImplementingInterfaces() {
        IntArithmetics.valueOf("PLUS")
        IntArithmetics.values()
        IntArithmetics.PLUS.name
        IntArithmetics.PLUS.ordinal

        IntArithmetics.PLUS.applyAsInt(1, 2)
        IntArithmetics.TIMES.applyAsInt(1, 2)

        plus(1, 2, IntArithmetics.PLUS::applyAsInt)
    }

    private fun plus(first:Int, second:Int, function: (Int, Int) -> Int) = function.invoke(first, second)

    /**
     * you can use
     *
     *  [enumValues] instead of Enum.values(),
     *
     *  [enumValueOf] instead of Enum.valueOf()
     */
    fun moreUsages() {
        getAllValues<Direction>()
        runCatching { getValueOf<Direction>("NORTH") }.getOrNull()
    }

    private inline fun <reified T : Enum<T>> getAllValues() : List<T> = enumValues<T>().toList()

    /**
     *
     * @throws IllegalStateException
     */
    private inline fun <reified T : Enum<T>> getValueOf(name: String) = enumValueOf<T>(name)
}
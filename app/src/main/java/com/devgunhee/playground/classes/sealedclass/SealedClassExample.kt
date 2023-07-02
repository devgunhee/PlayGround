package com.devgunhee.playground.classes.sealedclass

class SealedClassExample {

    fun howToUse() {
        /**
         * A sealed class is abstract by itself,
         * it cannot be instantiated directly and can have abstract members.
         */

        /**
         * "Error! cannot be instantiated directly"
         */
        // Sealed()

        /**
         * use it's subclass.
         */
        Data("sealed")

        /**
         * you can use [when] without [else] branch.
         */
        fun log(e: Error) = when(e) {
            is InputError -> {}
            is DatabaseError -> {}
            is FileReadError -> {}
            is SocketError -> {}
            is Data -> {}
            is RuntimeError -> {}
        }
    }
}


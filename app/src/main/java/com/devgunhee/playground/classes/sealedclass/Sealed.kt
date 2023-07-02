package com.devgunhee.playground.classes.sealedclass

import java.io.File
import javax.sql.DataSource

/**
 * Sealed Class can only have [private], [protected] constructor.
 *
 * this means, you can extends Sealed Class only in same p  package.
 *
 * default is [protected]
 */
sealed class Sealed {
    constructor() { /*...*/ } // protected by default
    private constructor(description: String) { /*...*/ } // private is OK
    // public constructor(code: Int): this() {} // Error: public and internal are not allowed
}

/**
 * you can use Sealed Interface
 */
sealed interface Error

sealed class IOError(): Error

/**
 * every Class can extends Sealed Class
 */
class FileReadError(val file: File): IOError()
open class DatabaseError(val source: DataSource): IOError()
object RuntimeError : Error
object InputError: IOError()
abstract class SocketError: IOError()
data class Data(val name: String) : IOError()



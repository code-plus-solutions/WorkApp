package com.example.network.model.base

/**
 * A sealed class to represent UI states associated with a result.
 */
sealed class Result<out T> {

    /**
     * A data class to represent the scenario where the result is available without any errors
     *
     * This is a terminal state, and the result object is considered to be completed when it is in this state
     */

    data class Success<out T>(
        val data: T
    ) : Result<T>() {
        operator fun invoke(): T {
            return data
        }
    }

    /**
     * `true` if [Result] is of type [Success] and holds non-null [Success.data]
     */

    val succeeded
        get() = this is Success && data != null

    /**
     * A data class to represent the scenario where a result may or may not be available due to an error
     *
     * This is a terminal state, and the result object is considered to be completed when it is in this state
     */
    data class Error(val exception: Throwable?, val errors: Any? = null) : Result<Nothing>()

    /**
     * A class to represent the loading state of an object
     *
     * This is a non-terminal state.
     */
    object Loading : Result<Nothing>() {
        var key: String? = null
        var percentage: Float? = null
        override fun hashCode(): Int {
            return 2
        }

        override fun equals(other: Any?): Boolean {
            return other is Loading
        }

    }

    object Empty : Result<Nothing>() {
        override fun hashCode(): Int {
            return 3
        }

        override fun equals(other: Any?): Boolean {
            return other is Loading
        }
    }


    abstract override fun hashCode(): Int
    abstract override fun equals(other: Any?): Boolean
}


class Server406Exception(message: String?) : Exception(message ?: "Server is unreachable!")

open class WebServiceException(message: String?) : Throwable(message ?: "Service is unreachable!")

class ServiceDownException(message: String?) : WebServiceException(message ?: "Server is unreachable!")

class RetryException:Exception("Please try again in a little while")

class ServerInternalError500(data:String):Exception(data)

class RequestError400(data:String):Exception(data)

class CheckConnectionError():Exception("No Internet Access!\nPlease check your connection and try again.")


suspend inline fun <T, R> Result<T>.changeState(crossinline transform: suspend (T) -> R): Result<R> {
    return this.let {
        when(it){
            is Result.Success -> Result.Success(transform(it.data))
            is Result.Error -> it
            is Result.Loading -> it
            is Result.Empty -> it
        }
    }
}
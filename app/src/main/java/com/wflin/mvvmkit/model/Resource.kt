package com.wflin.mvvmkit.model

/**
 * @author: wflin
 * @data: 2022/1/13
 * @desc:
 */
sealed class Resource<out T>(
    val data: T? = null,
    val code: Int? = null,
    val msg: String? = null
) {

    object Loading : Resource<Nothing>()

    class Success<T>(data: T) : Resource<T>(data)

    class DataError(code: Int? = 0, msg: String?) : Resource<Nothing>(null, code, msg)

}

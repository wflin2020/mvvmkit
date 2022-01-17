package com.wflin.mvvmkit.model.repository

import com.wflin.mvvmkit.model.Resource
import com.wflin.mvvmkit.model.remote.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.lang.Exception

/**
 * @author: wflin
 * @data: 2022/1/12
 * @desc:
 */
abstract class Repository {

    private val ioDispatcher = Dispatchers.IO

    fun <T> request(
        block: suspend () -> ApiResponse<T>
    ): Flow<Resource<T>> {
        return flow {
            emit(
                try {
                    val response = block()
                    if (response.isSuccess()) {
                        Resource.Success(response.data)
                    } else {
                        Resource.DataError(response.errorCode, response.errorMsg)
                    }
                } catch (ex: Exception) {
                    Resource.NetException(ex)
                }
            )
        }
    }
}
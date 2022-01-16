package com.wflin.mvvmkit.model.remote

/**
 * @author: wflin
 * @data: 2022/1/12
 * @desc: http请求返回数据基类
 */
abstract class ApiResponse<T>(
    val errorCode: Int?,
    val errorMsg: String?,
    val data: T
) {
    abstract fun isSuccess(): Boolean
}

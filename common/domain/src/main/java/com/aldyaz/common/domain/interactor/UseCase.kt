package com.aldyaz.common.domain.interactor

import com.aldyaz.common.domain.base.ResultState

abstract class UseCase<PARAM, RESULT> {

    abstract suspend fun execute(param: PARAM): ResultState<RESULT>

    suspend operator fun invoke(param: PARAM) = execute(param)

}
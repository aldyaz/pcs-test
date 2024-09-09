package com.aldyaz.datasource.member.cloud

import com.aldyaz.datasource.member.model.MemberDto
import retrofit2.Response
import retrofit2.http.GET

interface MemberService {

    @GET("getData/test")
    suspend fun getMemberList(): Response<List<MemberDto>>

}
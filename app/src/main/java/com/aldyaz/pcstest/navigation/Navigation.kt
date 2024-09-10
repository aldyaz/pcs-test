package com.aldyaz.pcstest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.aldyaz.member.ui.detail.MemberDetailPage
import com.aldyaz.member.ui.list.MemberListPage
import com.aldyaz.pcstest.navigation.route.Home
import com.aldyaz.pcstest.navigation.route.MemberDetail

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            MemberListPage(
                onClickItem = {
                }
            )
        }

        composable<MemberDetail> {
            val memberDetail = it.toRoute<MemberDetail>()
            MemberDetailPage(
                memberId = memberDetail.id
            )
        }
    }
}
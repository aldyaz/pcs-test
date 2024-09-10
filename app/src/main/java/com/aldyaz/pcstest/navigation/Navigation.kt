package com.aldyaz.pcstest.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldyaz.member.presentation.viewmodel.MemberSharedViewModel
import com.aldyaz.member.ui.detail.MemberDetailPage
import com.aldyaz.member.ui.list.MemberListPage
import com.aldyaz.pcstest.navigation.route.Home
import com.aldyaz.pcstest.navigation.route.MemberDetail

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val memberSharedViewModel: MemberSharedViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            MemberListPage(
                onClickItem = {
                    navController.navigate(MemberDetail)
                },
                sharedViewModel = memberSharedViewModel
            )
        }

        composable<MemberDetail> {
            MemberDetailPage(
                sharedViewModel = memberSharedViewModel,
                onBackPressed = {
                    navController.navigateUp()
                }
            )
        }
    }
}
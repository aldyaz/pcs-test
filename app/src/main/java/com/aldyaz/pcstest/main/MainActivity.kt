package com.aldyaz.pcstest.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.aldyaz.pcstest.R
import com.aldyaz.pcstest.databinding.ActivityMainBinding
import com.aldyaz.pcstest.navigation.AppNavigation
import com.aldyaz.pcstest.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.also {
            setContentView(it.root)
        }
        binding?.composeView?.setContent {
            AppTheme {
                AppNavigation()
            }
        }
    }

}
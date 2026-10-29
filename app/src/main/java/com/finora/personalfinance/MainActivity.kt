package com.finora.personalfinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.finora.personalfinance.ui.FinanceApp
import com.finora.personalfinance.ui.FinanceViewModel

class MainActivity : ComponentActivity() {
    private val vm: FinanceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceApp(vm)
        }
    }
}

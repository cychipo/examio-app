package com.examio.app.features.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Tài khoản", style = MaterialTheme.typography.headlineMedium)
        Text("Hồ sơ, cài đặt, ví/subscription và quản lý session sẽ được nối ở đây.")
        Text("Token phải lưu bằng secure storage theo từng nền tảng, không dùng plain preferences.")
    }
}

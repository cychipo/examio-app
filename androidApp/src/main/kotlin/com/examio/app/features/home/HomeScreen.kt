package com.examio.app.features.home

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
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Trang chủ", style = MaterialTheme.typography.headlineMedium)
        Text("Tổng quan học tập, kỳ thi gần nhất, tiến độ và shortcut vào AI sẽ nằm ở đây.")
        Text("Trạng thái cần hỗ trợ: loading, retry, empty state và session hết hạn.")
    }
}

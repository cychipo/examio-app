package com.examio.app.features.exams

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
fun MyExamsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Thi của tôi", style = MaterialTheme.typography.headlineMedium)
        Text("Danh sách kỳ thi, chi tiết phòng thi, làm bài và kết quả sẽ phát triển từ tab này.")
        Text("Không gọi API lặp vô hạn; các request ghi dữ liệu cần chống duplicate submit.")
    }
}

package com.examio.app.features.study

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
fun StudyScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Học tập", style = MaterialTheme.typography.headlineMedium)
        Text("Quiz, flashcard, tài liệu và tiến độ luyện tập sẽ được gom tại khu vực này.")
        Text("Danh sách dài cần pagination hoặc lazy loading khi nối API thật.")
    }
}

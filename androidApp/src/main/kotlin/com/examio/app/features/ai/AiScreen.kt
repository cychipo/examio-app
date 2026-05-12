package com.examio.app.features.ai

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
fun AiScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("AI", style = MaterialTheme.typography.headlineMedium)
        Text("Chat luyện lập trình, đánh giá code và chat với tài liệu sẽ dùng backend Examio hiện có.")
        Text("Mobile app không gọi trực tiếp AI provider và không hard-code provider trong app.")
    }
}

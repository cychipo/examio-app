package com.examio.app.features.navigation

enum class MainTab(
    val title: String,
    val description: String,
) {
    Home("Trang chủ", "Tổng quan học tập và việc cần làm tiếp theo"),
    Study("Học tập", "Quiz, flashcard và tài nguyên học tập"),
    MyExams("Thi của tôi", "Danh sách kỳ thi và kết quả"),
    Ai("AI", "Chat lập trình và công cụ AI học tập"),
    Account("Tài khoản", "Hồ sơ, cài đặt và phiên đăng nhập"),
}

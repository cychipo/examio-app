package com.examio.app.core.session

data class SessionTokens(
    val accessToken: String,
    val refreshToken: String?,
)

data class UserSession(
    val userId: String,
    val email: String,
    val displayName: String?,
    val roles: Set<UserRole>,
)

enum class UserRole {
    Student,
    Teacher,
    Admin,
}

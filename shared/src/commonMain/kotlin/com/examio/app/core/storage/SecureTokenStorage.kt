package com.examio.app.core.storage

import com.examio.app.core.session.SessionTokens

interface SecureTokenStorage {
    suspend fun readTokens(): SessionTokens?
    suspend fun saveTokens(tokens: SessionTokens)
    suspend fun clearTokens()
}

expect fun createSecureTokenStorage(): SecureTokenStorage

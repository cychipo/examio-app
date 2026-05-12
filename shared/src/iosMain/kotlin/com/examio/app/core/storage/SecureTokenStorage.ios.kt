package com.examio.app.core.storage

import com.examio.app.core.session.SessionTokens

actual fun createSecureTokenStorage(): SecureTokenStorage = IosSecureTokenStorage()

private class IosSecureTokenStorage : SecureTokenStorage {
    override suspend fun readTokens(): SessionTokens? = null

    override suspend fun saveTokens(tokens: SessionTokens) {
        throw NotImplementedError("iOS secure token storage must use Keychain before auth is enabled.")
    }

    override suspend fun clearTokens() = Unit
}

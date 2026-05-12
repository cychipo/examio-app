package com.examio.app.core.storage

import com.examio.app.core.session.SessionTokens

actual fun createSecureTokenStorage(): SecureTokenStorage = AndroidSecureTokenStorage()

private class AndroidSecureTokenStorage : SecureTokenStorage {
    override suspend fun readTokens(): SessionTokens? = null

    override suspend fun saveTokens(tokens: SessionTokens) {
        throw NotImplementedError("Android secure token storage must use Keystore-backed storage before auth is enabled.")
    }

    override suspend fun clearTokens() = Unit
}

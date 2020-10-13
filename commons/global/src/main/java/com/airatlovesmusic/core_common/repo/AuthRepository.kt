package com.airatlovesmusic.core_common.repo

import com.airatlovesmusic.core_network.ApiClient
import com.airatlovesmusic.core_common.data.Preferences

class AuthRepository(
    private val preferences: Preferences,
    private val apiClient: ApiClient
) {

    fun isAuthorized() = preferences.token != null

    suspend fun login(
        username: String,
        password: String
    ) = apiClient.login(username, password)

    suspend fun register(
        username: String,
        password: String
    ) = apiClient.register(username, password)

}
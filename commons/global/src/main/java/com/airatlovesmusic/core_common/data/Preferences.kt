package com.airatlovesmusic.core_common.data

import android.content.Context

class Preferences(
    private val context: Context
) {

    private fun getSharedPreferences(prefsName: String) =
        context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    private val authPrefs by lazy { getSharedPreferences(SP_AUTH) }
    private val appPrefs by lazy { getSharedPreferences(SP_COMMON) }

    var token: String?
        get() = authPrefs.getString(KEY_TOKEN, null)
        set(value) = authPrefs.edit().putString(KEY_TOKEN, value).apply()

    companion object {
        const val SP_COMMON = "sp_common"
        const val SP_AUTH = "sp_auth"
        const val KEY_TOKEN = "token"
    }

}
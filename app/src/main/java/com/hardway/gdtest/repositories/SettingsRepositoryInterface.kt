package com.hardway.gdtest.repositories

interface SettingsRepositoryInterface {
    fun isFirstRun(): Boolean
    fun setFirstRun(isFirstRun: Boolean)
}
package com.hardway.gdtest.repositories

import android.content.SharedPreferences
import com.hardway.gdtest.constants.Constants

class SettingsRepositoryImplementation(private val sharedPreferences: SharedPreferences):
    SettingsRepositoryInterface {
    override fun isFirstRun(): Boolean {
        return sharedPreferences.getBoolean(Constants.SavedData.IS_FIRST_RUN, true)
    }

    override fun setFirstRun(isFirstRun: Boolean) {
        sharedPreferences.edit().putBoolean(Constants.SavedData.IS_FIRST_RUN, isFirstRun).commit()
    }
}
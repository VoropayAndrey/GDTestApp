package com.hardway.gdtest.constants

object Constants {
    const val APP_NAME = "GDTestApp"
    const val TAG = APP_NAME + "_TAG"
    const val DATABASE_NAME = APP_NAME + "_CONTACT_DATABASE"

    object SavedData {
        const val SHARED_PREFERENCES_NAME = APP_NAME + "_SHARED_PREFERENCES_NAME"
        const val IS_FIRST_RUN = "_IS_FIRST_RUN"

    }

    object Network {
        const val BASE_URL = "https://randomuser.me"
    }
}
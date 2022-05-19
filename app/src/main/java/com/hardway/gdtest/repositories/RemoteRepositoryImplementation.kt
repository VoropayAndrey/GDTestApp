package com.hardway.gdtest.repositories

import android.content.Context
import com.hardway.gdtest.constants.Constants
import com.hardway.gdtest.domain.ContactEntity
import com.hardway.gdtest.repositories.network.RandomUserService
import com.hardway.gdtest.repositories.network.responses.GeneratedUserResponse
import com.hardway.gdtest.repositories.room.Contact
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RemoteRepositoryImplementation: RemoteRepositoryInterface {
    private var context: Context
    private var settingsRepository: SettingsRepositoryInterface

    private val interceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.Network.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    private val service: RandomUserService by lazy {
        retrofit.create(RandomUserService::class.java)
    }

    constructor(context: Context,
                settingsRepository: SettingsRepositoryInterface
    ) {
        this.context = context
        this.settingsRepository = settingsRepository

    }

    override suspend fun requestContact(): ContactEntity {
        var contact: ContactEntity? = null

        var response = service.generateUser()
        if(response.isSuccessful) {
            var generatedContact = response.body()!!
            contact = ContactEntity(firstName = generatedContact.results[0].name.first,
                lastName = generatedContact.results[0].name.last,
                photoURL = generatedContact.results[0].picture.large,
                phone1 = generatedContact.results[0].phone,
                phone2 = generatedContact.results[0].cell,
                email = generatedContact.results[0].email)
        } else {

        }

        return contact!!
    }
}
package com.hardway.gdtest.repositories

import android.content.Context
import com.hardway.gdtest.domain.entities.ContactEntity
import com.hardway.gdtest.repositories.network.RandomUserService

class RemoteRepositoryImplementation: RemoteRepositoryInterface {
    private var context: Context
    private var settingsRepository: SettingsRepositoryInterface
    private var service: RandomUserService

    constructor(context: Context,
                settingsRepository: SettingsRepositoryInterface,
                service: RandomUserService
    ) {
        this.context = context
        this.settingsRepository = settingsRepository
        this.service = service

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
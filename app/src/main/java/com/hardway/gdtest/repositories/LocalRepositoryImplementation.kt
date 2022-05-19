package com.hardway.gdtest.repositories

import android.content.Context
import com.hardway.gdtest.domain.entities.ContactEntity
import com.hardway.gdtest.repositories.room.AppDatabase
import com.hardway.gdtest.repositories.room.Contact
import java.util.*

class LocalRepositoryImplementation(private val context: Context,
                                    private val settingsRepository: SettingsRepositoryInterface,
                                    private val appDatabase: AppDatabase
): LocalRepositoryInterface {
    override suspend fun insert(vararg contacts: ContactEntity) {
        for (entity in contacts) {
            appDatabase.userDao().insertAll(entityToContact(entity))
        }
    }

    override suspend fun getAll(): List<ContactEntity> {
        val contacts = appDatabase.userDao().getAll()
        var resultList = LinkedList<ContactEntity>()
        for(contact in contacts) {
            resultList.add(contactToEntity(contact))
        }
        return resultList
    }

    override suspend fun deleteAll() {
        appDatabase.userDao().deleteAll()
    }

    override suspend fun getById(id: Int): ContactEntity {
        return contactToEntity(appDatabase.userDao().loadAllByIds(intArrayOf(id))[0])
    }

    private fun contactToEntity(contact: Contact): ContactEntity {
        return ContactEntity(id = contact.uid,
            firstName = contact.firstName,
            lastName = contact.lastName,
            email = contact.email,
            phone1 = contact.phone,
            photoURL = contact.photoURL
        )
    }

    private fun entityToContact(entity: ContactEntity): Contact {
        var contact = Contact(firstName = entity.firstName,
            lastName = entity.lastName,
            email = entity.email,
            phone = entity.phone1,
            photoURL = entity.photoURL
        )
        contact.uid = entity.id
        return contact
    }
}
package com.hardway.gdtest.domain

data class ContactEntity(val id: Int = 0,
                         val firstName: String,
                         val lastName: String,
                         val title: String = "Engineer",
                         val email: String = "dev@gmail.com",
                         val photoURL: String = "https://randomuser.me/api/portraits/med/women/72.jpg",
                         val gender: String = "male",
                         val phone1: String = "123455778",
                         val phone2: String = "234567890")

/*
"location": {
    "street": {
        "number": 8608,
        "name": "Avenida del Planetario"
    },
    "city": "Valladolid",
    "state": "Canarias",
    "country": "Spain",
    "postcode": 46878,
    "coordinates": {
        "latitude": "-25.8809",
        "longitude": "43.5768"
    },
    "timezone": {
        "offset": "-9:00",
        "description": "Alaska"
    }
},
"email": "vanesa.medina@example.com",
"login": {
    "uuid": "f891d2f2-6227-4409-ae46-6197b929bb23",
    "username": "greengorilla189",
    "password": "dixie1",
    "salt": "kkDqaLM4",
    "md5": "a6be0818d96c3b8908d2c9ae7cce0c7b",
    "sha1": "463baaed7c52ceb632c7644e128a0a9e6663b9d1",
    "sha256": "023e7d81292cfc129af38b993d53649e06b79cc2fa77169a42d248a930b068fd"
},
"dob": {
    "date": "1977-07-31T16:01:47.592Z",
    "age": 45
},
"registered": {
    "date": "2009-12-01T10:25:04.657Z",
    "age": 13
},
"phone": "951-577-118",
"cell": "653-458-420",
"id": {
    "name": "DNI",
    "value": "46826485-N"
},
"picture": {
    "large": "https://randomuser.me/api/portraits/women/72.jpg",
    "medium": "https://randomuser.me/api/portraits/med/women/72.jpg",
    "thumbnail": "https://randomuser.me/api/portraits/thumb/women/72.jpg"
},
"nat": "ES"
}
 */
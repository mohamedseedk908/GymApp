package com.ms.gymsapp

data class Gym(
    val id : Int,
    val name: String,
    val place: String,
    var isFavorite : Boolean = false
)
    val listOfGyms = listOf<Gym>(
        Gym(
            id = 1,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 2,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 3,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 4,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 5,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 6,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 7,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 8,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),   Gym(
            id = 9,
            name = "UpTown Gym",
            place = "20 El-Gihad, Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
        ),

    )

package com.bchmsl.homework9

data class User(
    var firstName: String,
    var lastName: String
) {
    var email: String = firstName.lowercase() + lastName.lowercase() + "@mail.ru"
}

val usersList = mutableListOf(
    User("Nika", "Tabatadze"),
    User("Luka", "Parchukidze"),
    User("Armen", "Garibyan"),
    User("Bachana", "Mosulishvili"),
    User("Baia", "Asanidze"),
    User("Davit", "Tsiskarashvili"),
    User("Dimitri", "Jibuti"),
    User("Giorgi", "Murgulia"),
    User("Giorgi", "Gabidauri"),
    User("Irakli", "Dekanosidze"),
    User("Ivane", "Kitoshvili"),
    User("Lika", "Khokhiashvili"),
    User("Luka", "Janjghava"),
    User("Luka", "Lomidze"),
    User("Luka", "Mazmishvili"),
    User("Luka", "Nikuradze"),
    User("Mariam", "Eristavi"),
    User("Mariam", "Namgaladze"),
    User("Nika", "Namoradze"),
    User("Otar", "Bakhtadze"),
    User("Tengiz", "Gachechiladze"),
    User("Vato", "Ruadze"),
    User("Gaga", "Lomidze"),
    User("Misho", "Tsitsishvili")
)

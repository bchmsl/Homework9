package com.bchmsl.homework9

data class User(
    var uid: Int,
    var firstName: String,
    var lastName: String
) {
    var email: String = firstName.lowercase() + lastName.lowercase() + "@mail.ru"
}

val usersList = mutableListOf(
    User(1, "Nika", "Tabatadze"),
    User(2, "Luka", "Parchukidze"),
    User(3, "Armen", "Garibyan"),
    User(4, "Bachana", "Mosulishvili"),
    User(5, "Baia", "Asanidze"),
    User(6, "Davit", "Tsiskarashvili"),
    User(7, "Dimitri", "Jibuti"),
    User(8, "Giorgi", "Murgulia"),
    User(9, "Giorgi", "Gabidauri"),
    User(10, "Irakli", "Dekanosidze"),
    User(11, "Ivane", "Kitoshvili"),
    User(12, "Lika", "Khokhiashvili"),
    User(13, "Luka", "Janjghava"),
    User(14, "Luka", "Lomidze"),
    User(15, "Luka", "Mazmishvili"),
    User(16, "Luka", "Nikuradze"),
    User(17, "Mariam", "Eristavi"),
    User(18, "Mariam", "Namgaladze"),
    User(19, "Nika", "Namoradze"),
    User(20, "Otar", "Bakhtadze"),
    User(21, "Tengiz", "Gachechiladze"),
    User(22, "Vato", "Ruadze"),
    User(23, "Gaga", "Lomidze"),
    User(24, "Misho", "Tsitsishvili")
)

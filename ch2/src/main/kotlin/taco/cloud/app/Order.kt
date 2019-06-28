package taco.cloud.app

data class Order(
    val name: String = "Foo Bar",
    val street: String = "Foo Street",
    val city: String = "Foo Ville",
    val state: String = "Bar",
    val zip: String = "FB42",
    val ccNumber: String = "8888 8888 8888 8888",
    val ccExpiration: String = "03/24",
    val ccCVV: String = "666"
)

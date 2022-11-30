package network

import com.squareup.moshi.Json

/**
 * People is a data class with two properties, name and spacecraft, where name is a String and spacecraft is a String.
 * @property {String} name - The name of the astronaut.
 * @property {String} spacecraft - The name of the spacecraft the person is on.
 */
data class People(
    @Json(name = "name")
    val name: String,
    @Json(name = "craft")
    val spacecraft: String
)

/**
 * `PeopleResponse` is a data class that has a property called `result` of type `List<People>`
 * @property {List<People>} result - This is the list of people that we will be getting from the API.
 */
data class PeopleResponse(
    @Json(name = "people")
    val result: List<People>
)

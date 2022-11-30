import network.ApiClient
import network.People
import network.PeopleResponse
import retrofit2.Call
import retrofit2.Response

// Exercises For Programmers by Brian P. Hogan
// Exercise 47: Who's In Space?
// James Hill, Houston, Texas, 2022
// GitHub: jhill1971 Twitter: @count_BASIC

fun main(args: Array<String>) {
    val client = ApiClient.apiService.fetchPeople("1")

    /* A callback function that is called when the response is received. */
    client.enqueue(object : retrofit2.Callback<PeopleResponse> {
        override fun onResponse(
            call: Call<PeopleResponse>,
            response: Response<PeopleResponse>
        ) {
            if (response.isSuccessful) {
                // print header
                System.out.format("%-20s%-2s","Astronaut","Spacecraft")
                println()
                for (x in 1..32){print("-")}
                println()

               // println("people" + response.body())
                val result = response.body()?.result
                result?.let {
                   result.forEach {
                       (System.out.format("%-20s%-2s","${it.name}","${it.spacecraft}\n")) }
                }
            }
        }

        override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
            println("failed" + t.message)
        }
    })
}
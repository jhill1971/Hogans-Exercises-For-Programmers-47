package network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


object ApiClient {

    /* It's defining a constant that contains the base URL of the API. */
    private val BASE_URL = "http://api.open-notify.org/"

    /* It's creating an instance of the Moshi class. */
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    /* It's creating an instance of the Retrofit class. */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder() // build something with retrofit
            .baseUrl(BASE_URL) // use the base url
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // then add the converter factory using Moshi
            .build() // then build
    }

    /* It's creating an instance of the ApiService interface. */
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

/* It's an interface that defines a method that returns a Call object that contains a PeopleResponse object */
interface ApiService{
    @GET("astros")
    fun fetchPeople(@Query("people")page:String): Call<PeopleResponse>
}
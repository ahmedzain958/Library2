package com.example.library2.jsonparsing


data class User(val id: Int, @SerializedName("name") val fullName: String)

// Parsing JSON to object
val jsonString = "{ \"id\": 1, \"name\": \"John Doe\" }"
val user: User = Gson().fromJson(jsonString, User::class.java)

// Converting object to JSON
val user = User(1, "John Doe")
val jsonString: String = Gson().toJson(user)

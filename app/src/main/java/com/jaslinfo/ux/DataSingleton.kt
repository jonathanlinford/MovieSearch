package com.jaslinfo.ux

import android.provider.ContactsContract
import java.net.URL

class DataSingleton private constructor() {
    private object Holder { val INSTANCE = DataSingleton() }

    companion object {
        val instance: DataSingleton by lazy { Holder.INSTANCE }
    }

    //Library info
    val nearbyMovies: ArrayList<Movie> = ArrayList()

    var user: User = User()
    var users: ArrayList<User> = ArrayList()

    fun initTest(data: DataSingleton) {

        data.user = User()
        data.user.newUser("Jonny", "jonny@jonny.com", true)

        var movies = arrayListOf(Movie().apply{
            id = 0
            title = "zero"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 1
            title = "one"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 2
            title = "two"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 3
            title = "three"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 4
            title = "four"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply {
            id = 5
            title = "five"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply {
            id = 6
            title = "size"
            coverDrawableId = R.drawable.space_jam_poster
        })

        user.pendingMovies = movies
        user.currentMovies = movies
        user.pastMovies = movies

        user.myMovies = movies
    }

}

class User {
    fun newUser(name: String, email: String, isPrimaryUser: Boolean): User{
        var newUser = User()
        newUser.id = genId()
        newUser.name = name
        newUser.email = email

        if(isPrimaryUser) {
            DataSingleton.instance.user = newUser
        }

        DataSingleton.instance.users.add(newUser)

        return newUser
    }

    fun updateUser(id: Int, user: User) {
        var data = DataSingleton.instance
        if (id == data.user.getId()) {
            data.user = user
        }

        data.users[id] = user
    }

    private var id: Int = 0
    var name: String = ""
    var email: String = ""

    var myMovies: ArrayList<Movie> = ArrayList()

    var pendingMovies: ArrayList<Movie> = ArrayList()
    var currentMovies: ArrayList<Movie> = ArrayList()
    var pastMovies: ArrayList<Movie> = ArrayList()

    fun getId(): Int {
        return this.id
    }

    private fun genId(): Int {
        return DataSingleton.instance.users.size
    }
}

class Movie {
    var id: Int = 0
    var owner: Int = 0
    var title: String? = ""
    var coverDrawableId: Int? = R.drawable.space_jam_poster
}
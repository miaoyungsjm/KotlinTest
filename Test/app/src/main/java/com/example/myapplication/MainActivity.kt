package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val persons = listOf(
            Person("A"),
            Person("B", age = 29)
        )

        val oldest = persons.maxBy { it.age ?: 0 }
        println("The oldest is : $oldest")

    }

    fun findPerson(it: Person) : Person {
        it.name == "A"
        return it
    }
}
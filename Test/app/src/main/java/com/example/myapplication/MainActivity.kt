package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    // Property must be initialized or be abstract
    var view: View? = null
    lateinit var mContentTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
    }

    private fun initView(): Unit {
        // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type View?
        view = findViewById(R.id.tv_main_content)
        view?.setBackgroundColor(Color.RED)

        mContentTv = findViewById(R.id.tv_main_content)
        mContentTv.setText("Hello Kotlin!")

        (view as? TextView)?.setText("as?")
        printViewId(view)
    }

    private fun printViewId(view: View?) {
        Log.d(TAG, "printViewId: " + view?.id)
    }

    private fun initData() {
        val persons = listOf(
            Person("A", null),
            Person("B", age = 29)
        )
        val oldest = maxAgePerson(persons)
        println("The oldest is : $oldest")
    }

    private fun maxAgePerson(persons: List<Person>): Person? {
        return persons.maxByOrNull { it.age ?: 0 }
    }
}
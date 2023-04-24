package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameText: EditText
    private lateinit var ageText: EditText
    private lateinit var safeside:SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameText =findViewById<EditText>(R.id.tvname)
        ageText = findViewById<EditText>(R.id.tvage)
        safeside = getSharedPreferences("my file", MODE_PRIVATE)
        edit=safeside.edit()

    }

    override fun onPause() {
        super.onPause()
        val name=nameText.text.toString()
        val age =ageText.text.toString().toInt()
        edit.apply(){
            putString("my_name",name)
            putInt("my_age",age)
            commit()

        }
    }

    override fun onResume() {
        super.onResume()
        val name = safeside.getString("my_name",null)
        val age = safeside.getInt("my_age",0)
        if(age!=0) {
            nameText.setText(age.toString())
        }
        ageText.setText("name")
    }

}
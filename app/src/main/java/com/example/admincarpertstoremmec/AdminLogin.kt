package com.example.admincarpertstoremmec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AdminLogin : AppCompatActivity() {

    lateinit var email: TextView
    lateinit var password: TextView
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        email = findViewById(R.id.edEmailLogin)
        password = findViewById(R.id.password)
        btn = findViewById(R.id.buttonLogin)



        btn.setOnClickListener{

            val email_: String = email.text.toString()
            val pw_: String = password.text.toString()

            if (email_ == "admin@gmail.com" && pw_ == "admin69"){
                startActivity(Intent(this@AdminLogin, WelcomePage::class.java))
            }else{
                //startActivity(Intent(this@AdminLogin, WelcomePage::class.java))
                Toast.makeText(applicationContext, "Enter valid account", Toast.LENGTH_LONG).show()
            }



        }


    }
}
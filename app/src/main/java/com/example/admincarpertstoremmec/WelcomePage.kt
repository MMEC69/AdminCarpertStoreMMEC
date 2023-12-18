package com.example.admincarpertstoremmec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class WelcomePage : AppCompatActivity() {

   lateinit var btn_pro_info: Button
   lateinit var btn_pro_add: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)


        btn_pro_info = findViewById(R.id.order_info)
        btn_pro_add = findViewById(R.id.product_adder)

        btn_pro_add.setOnClickListener{
            startActivity(Intent(this@WelcomePage, MainActivity::class.java))

        }

        btn_pro_info.setOnClickListener{
            startActivity(Intent(this@WelcomePage, OrderInfo::class.java))

        }



    }
}
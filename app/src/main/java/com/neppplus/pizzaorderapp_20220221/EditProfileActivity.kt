package com.neppplus.pizzaorderapp_20220221

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        setupEvents()
        setValues()
    }

    fun setupEvents(){

        btnSave.setOnClickListener {

            val inputNickname = edtNickname.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("nickname", inputNickname)
            setResult(RESULT_OK, resultIntent)
            finish()

        }

    }

    fun setValues(){

    }

}
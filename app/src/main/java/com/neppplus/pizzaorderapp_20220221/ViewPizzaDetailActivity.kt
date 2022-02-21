package com.neppplus.pizzaorderapp_20220221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neppplus.pizzaorderapp_20220221.datas.PizzaData
import kotlinx.android.synthetic.main.activity_view_pizza_detail.*

class ViewPizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pizza_detail)

        val pizzaData = intent.getSerializableExtra("pizzaInfo") as PizzaData

        Glide.with(this).load(pizzaData.storeImgUri).into(imgStoreLogo)
        txtStoreName.text = pizzaData.storeName


    }
}
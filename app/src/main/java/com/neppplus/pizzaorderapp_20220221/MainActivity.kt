package com.neppplus.pizzaorderapp_20220221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.pizzaorderapp_20220221.adapters.MainViewPagerAdapter
import com.neppplus.pizzaorderapp_20220221.adapters.PizzaAdapter
import com.neppplus.pizzaorderapp_20220221.datas.PizzaData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

    }

    fun setValues() {

//       뷰페이져에  fragment 어댑터 연결
        mAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mAdapter

//        탭레이아웃 , 뷰페이져 연결
        mainTanLayout.setupWithViewPager(mainViewPager)





    }
}
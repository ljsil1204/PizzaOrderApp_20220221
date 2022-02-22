package com.neppplus.pizzaorderapp_20220221.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp_20220221.R
import com.neppplus.pizzaorderapp_20220221.ViewStoreDetailActivity
import com.neppplus.pizzaorderapp_20220221.adapters.StoreAdapter
import com.neppplus.pizzaorderapp_20220221.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza.*

class PizzaFragment : Fragment() {

    lateinit var mAdapter : StoreAdapter

    val mPizzaList = ArrayList<StoreData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    fun setupEvents(){

//        피자 리스트뷰 클릭시 동작
        pizzaListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedPizza = mPizzaList[position]

            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("store", clickedPizza)
            startActivity(myIntent)


        }
    }

    fun setValues(){

//        피자 리스트뷰 데이터
        mPizzaList.add(StoreData("피자헛",2.5, "1588-5588",
            "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg",
            "https://www.pizzahut.co.kr/main"))
        mPizzaList.add(StoreData("파파존스", 5.0, "1577-8080",
            "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800",
            "https://pji.co.kr/"))
        mPizzaList.add(StoreData("도미노피자", 3.5, "1577-3082",
            "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png",
            "https://web.dominos.co.kr/main"))
        mPizzaList.add(StoreData("미스터피자", 4.0, "1577-0077",
            "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200",
            "https://www.mrpizza.co.kr/"))


//        리스트뷰 객체화 -> 프레그먼트 리스트뷰 어댑터에 연결
        mAdapter = StoreAdapter(requireContext(), R.layout.store_list_item, mPizzaList)
        pizzaListView.adapter = mAdapter
    }



}
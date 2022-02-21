package com.neppplus.pizzaorderapp_20220221.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.neppplus.pizzaorderapp_20220221.R
import com.neppplus.pizzaorderapp_20220221.ViewPizzaDetailActivity
import com.neppplus.pizzaorderapp_20220221.adapters.PizzaAdapter
import com.neppplus.pizzaorderapp_20220221.datas.PizzaData
import kotlinx.android.synthetic.main.fragment_pizza.*
import kotlinx.android.synthetic.main.pizza_list_item.*

class PizzaFragment : Fragment() {

    lateinit var mAdapter : PizzaAdapter

    val mPizzaList = ArrayList<PizzaData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        프레그먼트 동작 코드

//        피자 리스트뷰 데이터
        mPizzaList.add(PizzaData("피자헛",
            "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg",
            2.5))
        mPizzaList.add(PizzaData("파파존스",
            "https://mblogthumb-phinf.pstatic.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800",
            5.0))
        mPizzaList.add(PizzaData("도미노피자",
            "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png",
            4.0))
        mPizzaList.add(PizzaData("미스터피자",
            "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200",
            3.5))



//        리스트뷰 객체화 -> 프레그먼트 리스트뷰 어댑터에 연결
        mAdapter = PizzaAdapter(requireContext(), R.layout.pizza_list_item, mPizzaList)
        pizzaListView.adapter = mAdapter

        pizzaListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedPizza = mPizzaList[position]

            val myIntent = Intent(requireContext(), ViewPizzaDetailActivity::class.java)
            myIntent.putExtra("pizzaInfo", clickedPizza)
            startActivity(myIntent)

        }


    }



}
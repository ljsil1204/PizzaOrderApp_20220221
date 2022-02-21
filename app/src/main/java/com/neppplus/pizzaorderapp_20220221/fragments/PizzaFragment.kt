package com.neppplus.pizzaorderapp_20220221.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp_20220221.R
import com.neppplus.pizzaorderapp_20220221.adapters.PizzaAdapter
import com.neppplus.pizzaorderapp_20220221.datas.PizzaData
import kotlinx.android.synthetic.main.fragment_pizza.*

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
        mPizzaList.add(PizzaData("피자헛"))
        mPizzaList.add(PizzaData("파파존스"))
        mPizzaList.add(PizzaData("도미노피자"))
        mPizzaList.add(PizzaData("미스터피자"))
        mPizzaList.add(PizzaData("피자헛"))
        mPizzaList.add(PizzaData("파파존스"))
        mPizzaList.add(PizzaData("도미노피자"))
        mPizzaList.add(PizzaData("미스터피자"))

//        리스트뷰 객체화 -> 프레그먼트 리스트뷰 어댑터에 연결
        mAdapter = PizzaAdapter(requireContext(), R.layout.pizza_list_item, mPizzaList)
        pizzaListView.adapter = mAdapter

    }



}
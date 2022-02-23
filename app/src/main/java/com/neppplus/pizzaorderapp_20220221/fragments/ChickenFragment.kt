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
import kotlinx.android.synthetic.main.fragment_chicken.*

class ChickenFragment : Fragment() {

    lateinit var mAdapter : StoreAdapter
    val mChickenList = ArrayList<StoreData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chicken, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    fun setupEvents(){

//        치킨 리스트뷰 클릭시 동작
        chickenListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedChicken = mChickenList[position]

            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("store", clickedChicken)
            startActivity(myIntent)


        }
    }

    fun setValues(){

//        치킨 리스트뷰 데이터
        mChickenList.add(StoreData("교촌치킨",2.5, "1577-1991", "http://2.bp.blogspot.com/-kk4b9vZMcYg/VIlnsZyB1hI/AAAAAAAAlJ0/EQOv0DRyQIo/s1600/%EA%B5%90%EC%B4%8C%EC%B9%98%ED%82%A8%2B%EB%A1%9C%EA%B3%A0.png", "http://www.kyochon.com/main/"))
        mChickenList.add(StoreData("깐부치킨", 5.0, "1544-9226", "https://kkotsbom.com/kkotsbom/wp-content/uploads/2020/08/%EA%B9%90%EB%B6%80%EC%B9%98%ED%82%A8-1024x1024.png", "http://www.kkanbu.co.kr/home/"))
        mChickenList.add(StoreData("굽네치킨", 3.5, "1661-9494", "https://www.goobne.co.kr/resources/images/contents/brand/BI_KOR_2.jpg", "https://www.goobne.co.kr/index_1.jsp#0"))
        mChickenList.add(StoreData("BHC", 4.0, "1577-5577", "https://mblogthumb-phinf.pstatic.net/20160507_10/ppanppane_1462549491506P8Sej_PNG/Untitled-1-28.png?type=w800", "https://www.bhc.co.kr/"))
        mChickenList.add(StoreData("KFC", 4.0, "02)6020-8368", "https://i.pinimg.com/originals/4f/a2/91/4fa291fc7c8d2811958c1f8f06e70cdd.jpg", "https://www.kfckorea.com/"))


//        리스트뷰 객체화 -> 프레그먼트 리스트뷰 어댑터에 연결
        mAdapter = StoreAdapter(requireContext(), R.layout.store_list_item, mChickenList)
        chickenListView.adapter = mAdapter
    }



}
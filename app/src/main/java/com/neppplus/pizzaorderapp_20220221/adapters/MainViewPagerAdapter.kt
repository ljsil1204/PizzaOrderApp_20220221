package com.neppplus.pizzaorderapp_20220221.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.neppplus.pizzaorderapp_20220221.fragments.ChickenFragment
import com.neppplus.pizzaorderapp_20220221.fragments.ProfileFragment
import com.neppplus.pizzaorderapp_20220221.fragments.PizzaFragment

class MainViewPagerAdapter( fm : FragmentManager ) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> PizzaFragment()
            1 -> ChickenFragment()
            else -> ProfileFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "피자 주문"
            1 -> "치킨 주문"
            else -> "내 정보 설정"
        }
    }
}
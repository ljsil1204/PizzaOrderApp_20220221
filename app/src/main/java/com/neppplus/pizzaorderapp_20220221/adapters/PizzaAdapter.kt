package com.neppplus.pizzaorderapp_20220221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.neppplus.pizzaorderapp_20220221.R
import com.neppplus.pizzaorderapp_20220221.datas.PizzaData

class PizzaAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<PizzaData>,
) : ArrayAdapter<PizzaData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null){
            tempRow = LayoutInflater.from(context).inflate(R.layout.pizza_list_item, null)
        }

        val row = tempRow!!



        return row

    }

}
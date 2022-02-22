package com.neppplus.pizzaorderapp_20220221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.neppplus.pizzaorderapp_20220221.R
import com.neppplus.pizzaorderapp_20220221.datas.StoreData
import de.hdodenhof.circleimageview.CircleImageView
import me.zhanghai.android.materialratingbar.MaterialRatingBar

class StoreAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<StoreData>,
) : ArrayAdapter<StoreData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null){
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.store_list_item, null)
        }

        val row = tempRow!!

//        리스트뷰 한 칸마다 데이터 넣기
        val data = mList[position]

        val imgStoreLogo = row.findViewById<CircleImageView>(R.id.imgStoreLogo)
        val txtStoreName = row.findViewById<TextView>(R.id.txtStoreName)
        val storeRating = row.findViewById<MaterialRatingBar>(R.id.storeRating)

        Glide.with(mContext).load(data.storeImgUri).into(imgStoreLogo)
        txtStoreName.text = data.storeName
        storeRating.rating = data.storeRating.toFloat()

        return row

    }

}
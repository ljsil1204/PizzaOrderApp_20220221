package com.neppplus.pizzaorderapp_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.pizzaorderapp_20220221.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : AppCompatActivity() {

    lateinit var mStoreData : StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        mStoreData = intent.getSerializableExtra("store") as StoreData
        setupEvents()
        setValues()
    }

    fun setupEvents() {

//        전화걸기 권한 얻어오는 라이브러리
        val pl = object : PermissionListener{
            override fun onPermissionGranted() {
                val myUri = Uri.parse("tel:${mStoreData.storePhoneNum}")
                val myIntent = Intent( Intent.ACTION_CALL,  myUri )
                startActivity( myIntent )
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@ViewStoreDetailActivity, "권한이 거절되어 전화를 걸 수 없습니다", Toast.LENGTH_SHORT).show()
            }
        }

        btnCall.setOnClickListener {
            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

    }

    fun setValues() {

        Glide.with(this).load(mStoreData.storeImgUri).into(imgStoreLogo)
        txtStoreName.text = mStoreData.storeName
        txtPhoneNum.text = mStoreData.storePhoneNum
        storeRating.rating = mStoreData.storeRating.toFloat()
        txtRating.text = "(${mStoreData.storeRating})"

    }

}
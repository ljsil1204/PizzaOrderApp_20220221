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

//        사이트 연결 버튼 클릭 시  인터넷 사이트로 연결

        btnLink.setOnClickListener {
            val myUri = Uri.parse("${mStoreData.storeWebURL}")  // 사이트 주소 바로 입력.
            val myIntent = Intent( Intent.ACTION_VIEW,  myUri )
            startActivity( myIntent )
        }

    }

    fun setValues() {

//        스토어 데이터 태그에 맞춰서 넣기
        Glide.with(this).load(mStoreData.storeImgUri).into(imgStoreLogo)
        txtStoreName.text = mStoreData.storeName
        txtPhoneNum.text = mStoreData.storePhoneNum
        storeRating.rating = mStoreData.storeRating.toFloat()
        txtRating.text = "(${mStoreData.storeRating})"
        txtWebSite.text = mStoreData.storeWebURL
    }

}
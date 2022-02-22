package com.neppplus.pizzaorderapp_20220221

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.pizzaorderapp_20220221.datas.PizzaData
import kotlinx.android.synthetic.main.activity_view_pizza_detail.*

class ViewPizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pizza_detail)

        val pizzaData = intent.getSerializableExtra("pizzaInfo") as PizzaData

        Glide.with(this).load(pizzaData.storeImgUri).into(imgStoreLogo)
        txtStoreName.text = pizzaData.storeName


        val pl = object : PermissionListener{
            override fun onPermissionGranted() {
                val myUri = Uri.parse("tel:01033337777")
                val myIntent = Intent( Intent.ACTION_CALL,  myUri )
                startActivity( myIntent )
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

            }
        }

//        TedPermission.create()
//            .setPermissionListener(pl)
//            .setPermissions()

    }
}
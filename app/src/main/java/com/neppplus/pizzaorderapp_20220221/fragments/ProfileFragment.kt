package com.neppplus.pizzaorderapp_20220221.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp_20220221.EditProfileActivity
import com.neppplus.pizzaorderapp_20220221.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val REQ_CODE_NICKNAME = 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        프레그먼트 동작 코드
        setupEvents()
        setValues()
    }


    fun setupEvents(){

        btnNickName.setOnClickListener {

            val myIntent = Intent(requireContext(), EditProfileActivity::class.java)
            startActivityForResult(myIntent, REQ_CODE_NICKNAME)

        }

    }

    fun setValues() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE_NICKNAME) {

            if (resultCode == Activity.RESULT_OK ){

                val newNickname = data?.getStringExtra("nickname")
                txtNickname.text = newNickname
            }

        }

    }

}
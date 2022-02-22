package com.neppplus.pizzaorderapp_20220221.datas

import java.io.Serializable


class StoreData(
    val storeName : String,
    val storeRating : Double,
    val storePhoneNum : String,
    val storeImgUri : String,
    val storeWebURL : String,
) : Serializable {

}
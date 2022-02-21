package com.neppplus.pizzaorderapp_20220221.datas

import java.io.Serializable


class PizzaData(
    val storeName : String,
    val storeImgUri : String,
    val storeRating : Double,
) : Serializable {

}
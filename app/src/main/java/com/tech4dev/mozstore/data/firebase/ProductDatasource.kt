package com.tech4dev.mozstore.data.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tech4dev.mozstore.data.models.Product


class ProductDatasource {
    //Get references to firebase database
  private  val db = Firebase.firestore

    //Create function that will fetch the products from the firebase

    fun getProductsInfo(): MutableLiveData<List<Product>>{
        val productLiveData = MutableLiveData<List<Product>>()

        db.collection("products")
          .get()
         //Call back function
          .addOnSuccessListener { documents ->
              val listOfProduct: List<Product> = documents.toObjects(Product::class .java)
              productLiveData.value = listOfProduct
              }


          .addOnFailureListener{ error ->
              Log.e("Firebase Error,", error.message.toString())
          }
        return productLiveData
    }
}
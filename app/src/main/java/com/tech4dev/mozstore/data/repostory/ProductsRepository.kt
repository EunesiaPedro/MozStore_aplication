package com.tech4dev.mozstore.data.repostory

import androidx.lifecycle.MutableLiveData
import com.tech4dev.mozstore.data.firebase.ProductDatasource
import com.tech4dev.mozstore.data.models.Product

class ProductsRepository {

    fun getProducts(): MutableLiveData<List<Product>>{
        val productDatasource = ProductDatasource()

        return productDatasource.getProductsInfo()
    }

}
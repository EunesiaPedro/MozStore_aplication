package com.tech4dev.mozstore.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech4dev.mozstore.data.models.Product
import com.tech4dev.mozstore.data.repostory.ProductsRepository

class HomeViewModel : ViewModel() {
 private val productsRepository = ProductsRepository()
 private val products: MutableLiveData<List<Product>> = productsRepository.getProducts()

    fun getAllProduct(): MutableLiveData<List<Product>>{
        return products
    }

}
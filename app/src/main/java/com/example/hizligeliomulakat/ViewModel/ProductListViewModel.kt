package com.example.hizligeliomulakat.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hizligeliomulakat.Model.Product

class ProductListViewModel : ViewModel() {
    val products = MutableLiveData<List<Product>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Boolean>()

    fun loadDatFromAPI(selectedCategory: String?) : List<Product> {
        if (selectedCategory == null) {

            val product = Product(
                1,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                22.3,
                "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            val product2 = Product(
                2,
                "Mens Casual Premium Slim Fit T-Shirts",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jp"
            )

            val product3 = Product(
                3,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            val product4 = Product(
                4,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            val product5 = Product(
                5,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            val product6 = Product(
                6,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            val product7 = Product(
                7,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            val product8 = Product(
                8,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )

            products.value = listOf<Product>(
                product,
                product2,
                product3,
                product4,
                product5,
                product6,
                product7,
                product8
            )
            isError.value = false
            isLoading.value = false

            return products.value!!
        } else {
            return listOf()
        }
    }
}


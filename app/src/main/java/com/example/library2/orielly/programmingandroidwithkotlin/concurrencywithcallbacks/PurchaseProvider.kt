package com.example.library2.orielly.programmingandroidwithkotlin.concurrencywithcallbacks

interface PurchaseProvider {
    fun interface PurchaseFetchCallback {
        fun onPurchaseFetchDone(purchases: List<String>)
    }

    fun fetchPurchases(user: String, callback: PurchaseFetchCallback)
}

interface BillingClient {

    fun interface BillingCallback {
        fun onInitDone(provider: PurchaseProvider?)
    }
//init method says that implementations should be non-blocking.
    fun init(callback: BillingCallback)
}
package com.example.library2.cleanarchitecture_cleancode.tight_coupling
/*
Tight Coupling: if we wanted to switch to a different payment gateway, we would need to modify the paymentprocessor class,
 potentially causing ripple effects throughout the codebase
 */
class PaymentProcessor {
    private val paymentGateway = PaypalGateway()
    fun processPayment(amount: Float) {
        paymentGateway.authenticate()
        paymentGateway.processPayment(amount)
        paymentGateway.sendConfirmation()

    }
}

class PaypalGateway {
    fun authenticate() {

    }

    fun processPayment(amount: Float) {

    }

    fun sendConfirmation() {


    }

}

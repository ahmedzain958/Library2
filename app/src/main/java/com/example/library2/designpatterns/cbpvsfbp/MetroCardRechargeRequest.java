package com.example.library2.designpatterns.cbpvsfbp;
//https://medium.com/xebia-engineering/fluent-builder-pattern-with-a-real-world-example-7b61be375a40
public class MetroCardRechargeRequest {

    private long cardNumber;
    private double amount;
    private String promoCode;

    private MetroCardRechargeRequest(Builder builder) {
        cardNumber = builder.cardNumber;
        amount = builder.amount;
        promoCode = builder.promoCode;

    }

    public static final class Builder {
        private long cardNumber;
        private double amount;
        private String promoCode;

        Builder() {
        }

        Builder setCardNumber(long val) {
            cardNumber = val;
            return this;
        }

        public Builder setAmount(double val) {
            amount = val;
            return this;
        }

        Builder setPromoCode(String val) {
            promoCode = val;
            return this;
        }

        MetroCardRechargeRequest build() {
            return new MetroCardRechargeRequest( this );
        }
    }
}

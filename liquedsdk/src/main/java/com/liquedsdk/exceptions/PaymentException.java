package com.liquedsdk.exceptions;

public class PaymentException extends Exception {

    public PaymentException(String error)
    {
        super(error);
    }
}

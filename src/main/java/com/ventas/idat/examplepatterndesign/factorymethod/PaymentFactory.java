package com.ventas.idat.examplepatterndesign.factorymethod;

public class PaymentFactory {

    private PaymentFactory() {}

    public static Payment getPayment(String method) {
        if("paypal".equals(method)) return new PaypalPayment();
        if("yape".equals(method)) return new YapePayment();
        throw new IllegalArgumentException("Metodo de pago no sportado");
    }

}

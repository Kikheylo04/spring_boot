package com.ventas.idat.examplepatterndesign.factorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaypalPayment implements Payment {

    @Override
    public void process() {
        log.info("Creando metodo con Paypal");
    }

}

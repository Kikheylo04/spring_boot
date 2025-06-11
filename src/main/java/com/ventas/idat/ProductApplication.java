package com.ventas.idat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ventas.idat.examplepatterndesign.Counter;
import com.ventas.idat.examplepatterndesign.CounterService;
import com.ventas.idat.examplepatterndesign.CounterSingleton;
import com.ventas.idat.examplepatterndesign.factorymethod.Payment;
import com.ventas.idat.examplepatterndesign.factorymethod.PaymentFactory;

@SpringBootApplication
public class ProductApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);


		Counter count1 = new Counter();
		Counter count2 = new Counter();
		count1.increment();
		logger.info("count1 valor = {}", count1.getCount());
		logger.info("count2 valor = {}", count2.getCount());

		CounterSingleton c1 = CounterSingleton.getInstance();
		CounterSingleton c2 = CounterSingleton.getInstance();
		c1.increment();
		logger.info("count singleton 1 = {}", c1.getCount());
		logger.info("count singletos 2 = {}", c2.getCount());

		CounterService service = new CounterService();
		service.increment();

		CounterService service2 = new CounterService();
		logger.info("count service = {}", service.getCount());
		logger.info("count service 2 = {}", service2.getCount());

		Payment payment = PaymentFactory.getPayment("yape");
		payment.process();
		Payment payment2 = PaymentFactory.getPayment("paypal");
		payment2.process();
	}

}

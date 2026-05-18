package br.com.cantarutti.ms_order_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.cantarutti.ms_order_processor.model")
public class MsOrderProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOrderProcessorApplication.class, args);
	}

}

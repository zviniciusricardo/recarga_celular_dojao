package br.com.zupacademy.grupolaranja.recargacelular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RecargacelularApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecargacelularApplication.class, args);
	}

}

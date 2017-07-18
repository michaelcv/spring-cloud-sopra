package com.sopra.boot.atelier1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Atelier1Application {

	public static void main(String[] args) {
		MyBean myBean = SpringApplication.run(Atelier1Application.class, args).getBean(MyBean.class);

		System.out.println(myBean);
	}

	@Component
	public class MyBean {

	}
}

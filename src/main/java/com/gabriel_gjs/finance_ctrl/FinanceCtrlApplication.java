package com.gabriel_gjs.finance_ctrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/api/v1")
public class FinanceCtrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceCtrlApplication.class, args);
	}

}

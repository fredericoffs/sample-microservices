package com.fredericoffs.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

	// para gerar o bcrypt com as senhas de user
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	// para gerar o bcrypt com as senhas de user
	@Override
	public void run(String... args) throws Exception {
		// System.out.println("BCrypt = " + passwordEncoder.encode("123456"));
		// BCrypt = $2a$10$Jrn6pDIPD2M0zDZz.LKO.eF7DuzDizvBdUy61UE7kIkMD09aNrIJa

	}

}

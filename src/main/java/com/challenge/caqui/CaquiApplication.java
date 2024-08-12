package com.challenge.caqui;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.challenge.caqui.common.enums.BenefitCategory;
import com.challenge.caqui.repository.AccountRepository;
import com.challenge.caqui.repository.MccRepository;
import com.challenge.caqui.repository.MerchantRepository;
import com.challenge.caqui.repository.entity.AccountEntity;
import com.challenge.caqui.repository.entity.MccEntity;
import com.challenge.caqui.repository.entity.MerchantEntity;

@SpringBootApplication
public class CaquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaquiApplication.class, args);
	}
}

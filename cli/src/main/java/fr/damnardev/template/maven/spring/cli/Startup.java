package fr.damnardev.template.maven.spring.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.damnardev.template.maven.spring.common.Calculator;

@SpringBootApplication(scanBasePackages = {
		"fr.damnardev.template.maven.spring.cli",
		"fr.damnardev.template.maven.spring.common"
})
public class Startup implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

	private final Calculator calculator;

	public Startup(Calculator calculator) {
		this.calculator = calculator;
	}

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

	@Override
	public void run(String... args) {
		LOGGER.info("10 + 10 = {}", this.calculator.add(10, 10));
	}

}

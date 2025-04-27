package br.com.mr.aspect_log;

import br.com.mr.aspect_log.testelocal.Teste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectLogApplication implements CommandLineRunner {

	@Autowired
	Teste teste;

	public static void main(String[] args) {
		SpringApplication.run(AspectLogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		teste.soma(10, 10);
		teste.subtracao(40, 15);
	}
}

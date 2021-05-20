package br.com.zup.orangetalents.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CasaDoCodigoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CasaDoCodigoApplication.class, args);
		
		ObjectMapper mapper = context.getBean(ObjectMapper.class);
	}

}

package br.com.zup.orangetalents.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.zup.orangetalents.casadocodigo.autor.model.Autor;
import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;

@SpringBootApplication
public class CasaDoCodigoApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(CasaDoCodigoApplication.class, args);
		
//		System.out.println(appContext.getBean(AutorRepository.class).findById(4L).get().getDataCriacao().toString());
}

}

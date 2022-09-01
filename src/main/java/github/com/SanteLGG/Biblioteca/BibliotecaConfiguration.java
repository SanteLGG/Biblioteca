package github.com.SanteLGG.Biblioteca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BibliotecaConfiguration {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de emprestimo de livros";
    }
}

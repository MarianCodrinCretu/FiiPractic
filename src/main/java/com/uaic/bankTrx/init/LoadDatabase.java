package com.uaic.bankTrx.init;

import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j

public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository)
    {
        return args ->
        {
            log.info("Preloading " + repository.save(new User("Ana Maria Vlad", 1258.75)));
            log.info("Preloading " + repository.save(new User( "Marian Codrin Cretu", 1258.75)));
        };
    }
}

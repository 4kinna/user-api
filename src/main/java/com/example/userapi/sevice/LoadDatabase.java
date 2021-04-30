/*package com.example.userapi.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User( "", "Ted Nilsson", "Green Adviser", "tednilsson@greenadviser.se", "0700000000")));
            log.info("Preloading " + repository.save(new User( "", "Anton Stålhandske", "Green Adviser", "Antonstalhandske@greenadviser.se", "0700000000")));
            log.info("Preloading " + repository.save(new User( "", "Victor Håkansson", "Green Adviser", "Victorhakansson@greenadviser.se", "0700000000")));
        };
    }

}*/

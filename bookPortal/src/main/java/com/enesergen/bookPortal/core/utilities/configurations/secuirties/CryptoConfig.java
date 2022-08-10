package com.enesergen.bookPortal.core.utilities.configurations.secuirties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CryptoConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new MyPasswordEncoder();
    }
}

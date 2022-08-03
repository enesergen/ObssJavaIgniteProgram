package com.enesergen.obss.springStarter.springStarter.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CryptoConfig{
@Bean
    public PasswordEncoder encoder(){
    return new OurPasswordEncoder();//or new BCryptPasswordEncoder
}
}

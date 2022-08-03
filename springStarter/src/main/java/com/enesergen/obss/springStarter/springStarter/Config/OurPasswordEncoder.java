package com.enesergen.obss.springStarter.springStarter.Config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class OurPasswordEncoder extends BCryptPasswordEncoder {

}

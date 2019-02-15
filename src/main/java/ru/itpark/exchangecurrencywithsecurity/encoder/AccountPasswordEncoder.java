package ru.itpark.exchangecurrencywithsecurity.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountPasswordEncoder extends BCryptPasswordEncoder {
}

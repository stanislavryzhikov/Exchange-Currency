package ru.itpark.exchangecurrencywithsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itpark.exchangecurrencywithsecurity.entity.AccountEntity;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.entity.OperationEntity;
import ru.itpark.exchangecurrencywithsecurity.repository.AccountRepository;
import ru.itpark.exchangecurrencywithsecurity.repository.CurrencyRepository;
import ru.itpark.exchangecurrencywithsecurity.repository.OperationRepository;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ExchangeCurrencyWithSecurityApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ExchangeCurrencyWithSecurityApplication.class, args);
        var repository = context.getBean(AccountRepository.class);
        var encoder = context.getBean(PasswordEncoder.class);
        var currencyRepository = context.getBean(CurrencyRepository.class);
        var operationRepository = context.getBean(OperationRepository.class);

        //Операции
        operationRepository.saveAll(List.of(new OperationEntity(0, "Покупка валюты","EUR", 75.55f, 73.55f,16.12f,1185.63f,"Иванов", "Иван", "Иванович", 1242, 231123, "Тестовая операция")));
        //Начальные валюты
        currencyRepository.saveAll(List.of(new CurrencyEntity(0,"USD", 65.55f, 63.55f, 67.55f, "Доллар США")));
        currencyRepository.saveAll(List.of(new CurrencyEntity(0,"EUR", 75.55f, 73.55f, 77.55f, "ЕВРО")));
        // регистрация
        repository.saveAll(
                List.of(
                        new AccountEntity(
                                0,
                                "admin",
                                encoder.encode("admin"),
                                List.of(
                                        new SimpleGrantedAuthority("ADD"),
                                        new SimpleGrantedAuthority("REMOVE")
                                ),
                                true,
                                true,
                                true,
                                true
                        ),
                        new AccountEntity(
                                0,
                                "user",
                                encoder.encode("user"),
                                Collections.emptyList(),
                                true,
                                true,
                                true,
                                true
                        )
                )
        );
    }

}


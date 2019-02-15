package ru.itpark.exchangecurrencywithsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.exchangecurrencywithsecurity.entity.AccountEntity;
import ru.itpark.exchangecurrencywithsecurity.entity.AccountEntity;

import java.util.Optional;

public interface AccountRepository
        extends JpaRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findByUsername(String username); // Derived queries
}

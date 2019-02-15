package ru.itpark.exchangecurrencywithsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;

public interface CurrencyRepository
        extends JpaRepository<CurrencyEntity, Integer> { // Integer - то, над чем написано @Id
    // boolean existsByOwnerIdAndId(int ownerId, int id);
}

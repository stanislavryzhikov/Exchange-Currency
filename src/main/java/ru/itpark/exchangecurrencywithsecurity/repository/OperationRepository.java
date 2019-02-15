package ru.itpark.exchangecurrencywithsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.entity.OperationEntity;

public interface OperationRepository
        extends JpaRepository<OperationEntity, Integer> { // Integer - то, над чем написано @Id
    // boolean existsByOwnerIdAndId(int ownerId, int id);
}

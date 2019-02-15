package ru.itpark.exchangecurrencywithsecurity.service;

import org.springframework.stereotype.Service;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.repository.CurrencyRepository;

import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;
    //private final OperationRepository operationRepository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public List<CurrencyEntity> findAll() {
        return repository.findAll();
    }


    public CurrencyEntity findById(int id) {
        return repository.findById(id)
                .orElseThrow(); //
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }

    public void add(CurrencyEntity entity) {
        repository.save(entity); //
    }

}

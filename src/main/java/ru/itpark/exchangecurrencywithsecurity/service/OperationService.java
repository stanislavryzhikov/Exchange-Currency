package ru.itpark.exchangecurrencywithsecurity.service;

import org.springframework.stereotype.Service;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.entity.OperationEntity;
import ru.itpark.exchangecurrencywithsecurity.repository.CurrencyRepository;
import ru.itpark.exchangecurrencywithsecurity.repository.OperationRepository;

import java.util.List;

@Service
public class OperationService {
    private final OperationRepository repository;
    //private final OperationRepository operationRepository;

    public OperationService(OperationRepository repository) {
        this.repository = repository;
    }

    public List<OperationEntity> findAll() {
        return repository.findAll();
    }


    public OperationEntity findById(int id) {
        return repository.findById(id)
                .orElseThrow(); // TODO: throw specific exception
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }

    public void add(OperationEntity entity) {
        repository.save(entity); // TODO: add edit functionality
    }

//    public void saveOperation(OperationEntity entity) {
//        operationRepository.save(entity);
//    }

}

package ru.itpark.exchangecurrencywithsecurity.rest;

import org.springframework.web.bind.annotation.*;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.entity.OperationEntity;
import ru.itpark.exchangecurrencywithsecurity.service.CurrencyService;
import ru.itpark.exchangecurrencywithsecurity.service.OperationService;

import java.util.List;

@RestController
@RequestMapping("/api/operations")
public class RestOperationController {
    private final OperationService service;

    public RestOperationController(OperationService service) {
        this.service = service;
    }

    @GetMapping
    public List<OperationEntity> getAll() {
        return service.findAll();
    }

    @PostMapping
    public void add(@RequestBody OperationEntity entity) {

    }
}

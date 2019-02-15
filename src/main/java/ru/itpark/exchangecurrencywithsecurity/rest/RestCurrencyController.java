package ru.itpark.exchangecurrencywithsecurity.rest;

import org.springframework.web.bind.annotation.*;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class RestCurrencyController {
    private final CurrencyService service;

    public RestCurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<CurrencyEntity> getAll() {
        return service.findAll();
    }

    @PostMapping
    public void add(@RequestBody CurrencyEntity entity) {

    }
}

package ru.itpark.exchangecurrencywithsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.exchangecurrencywithsecurity.entity.OperationEntity;
import ru.itpark.exchangecurrencywithsecurity.service.CurrencyService;
import ru.itpark.exchangecurrencywithsecurity.service.OperationService;

@Controller
@RequestMapping("/operations")
public class OperationController {
    private final OperationService service;

    private final CurrencyService currencyService;

    public OperationController(OperationService service, CurrencyService currencyService) {
        this.service = service;
        this.currencyService = currencyService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("operations", service.findAll());

        return "pages/operations";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @GetMapping("/add")
    public String addForm() {
        return "pages/operation-add";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @PostMapping("/add")
    public String add(@ModelAttribute OperationEntity operation) {
        service.add(operation);

        return "redirect:/operations";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("operation", service.findById(Integer.parseInt(id)));
        return "pages/operation-edit";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute OperationEntity operation, @PathVariable String id) {
        service.add(operation);

        return "redirect:/operations";
    }

    //Покупка валюты
    @GetMapping("/{id}/buy")
    public String buyForm(@PathVariable String id, Model model) {
        model.addAttribute("currency", currencyService.findById(Integer.parseInt(id)));
        return "pages/operation-buy";
    }

    @PostMapping("/{id}/buy")
    public String buy(@ModelAttribute OperationEntity operation, @PathVariable String id) {
        //Метод для buy
        service.add(operation);

        return "redirect:/operations";
    }
    //Покупка валюты

    //Продажа валюты
    @GetMapping("/{id}/sell")
    public String sellForm(@PathVariable String id, Model model) {
        model.addAttribute("currency", currencyService.findById(Integer.parseInt(id)));
        return "pages/operation-sell";
    }

    @PostMapping("/{id}/sell")
    public String sell(@ModelAttribute OperationEntity operation, @PathVariable String id) {
        //Метод для sell
        service.add(operation);

        return "redirect:/operations";
    }
    //продажа валюты

    @GetMapping("/{id}") // {id} -> /notes/1
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("operation", service.findById(id));

        return "pages/operation";
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @PostMapping("/{id}/remove")
    public String remove(@PathVariable int id) {
        service.removeById(id);

        return "redirect:/operations";
    }

    @PreAuthorize("@accountService.isOwned(#id)") // #id -> @PathVariable int id
    @GetMapping("/{id}/owned")
    public String preAuthorizeWithOurService(@PathVariable int id) {
        return "pages/owned";
    }

    //Переход на Валюты
    @GetMapping("/currencies")
    public String operationsForm() {
        return "pages/currencies";
    }

}

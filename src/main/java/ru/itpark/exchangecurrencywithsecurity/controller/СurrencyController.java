package ru.itpark.exchangecurrencywithsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.exchangecurrencywithsecurity.entity.CurrencyEntity;
import ru.itpark.exchangecurrencywithsecurity.service.CurrencyService;

@Controller
@RequestMapping("/currencies")
public class СurrencyController {
    private final CurrencyService service;

    public СurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("currencies", service.findAll());

        return "pages/currencies";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @GetMapping("/add")
    public String addForm() {
        return "pages/currency-add";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @PostMapping("/add")
    public String add(@ModelAttribute CurrencyEntity currency) {
        service.add(currency);

        return "redirect:/currencies";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("currency", service.findById(Integer.parseInt(id)));
        return "pages/currency-edit";
    }

    @PreAuthorize("hasAuthority('ADD')")
    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute CurrencyEntity currency, @PathVariable String id) {
        service.add(currency);

        return "redirect:/currencies";
    }


//    //переход в Операции
//    @GetMapping("/operations")
//    public String operationForm() {
//        return "pages/operations";
//    }

    //Покупка валюты
    @GetMapping("/{id}/buy")
    public String buyForm(@PathVariable String id, Model model) {
        model.addAttribute("currency", service.findById(Integer.parseInt(id)));
        return "pages/currency-buy";
    }

    @PostMapping("/{id}/buy")
    public String buy(@ModelAttribute CurrencyEntity currency, @PathVariable String id) {
        //Метод для buy
        //service.add(currency);

        return "redirect:/currencies";
    }
    //Покупка валюты

    //Продажа валюты
    @GetMapping("/{id}/sell")
    public String sellForm(@PathVariable String id, Model model) {
        model.addAttribute("currency", service.findById(Integer.parseInt(id)));
        return "pages/currency-sell";
    }

    @PostMapping("/{id}/sell")
    public String sell(@ModelAttribute CurrencyEntity currency, @PathVariable String id) {
        //Метод для sell
        //service.add(currency);

        return "redirect:/currencies";
    }
    //продажа валюты

    @GetMapping("/{id}") // {id} -> /notes/1
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("currency", service.findById(id));

        return "pages/currency";
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @PostMapping("/{id}/remove")
    public String remove(@PathVariable int id) {
        service.removeById(id);

        return "redirect:/currencies";
    }

    @PreAuthorize("@accountService.isOwned(#id)") // #id -> @PathVariable int id
    @GetMapping("/{id}/owned")
    public String preAuthorizeWithOurService(@PathVariable int id) {
        return "pages/owned";
    }

    //Переход на Операции
    @GetMapping("/operations")
    public String operationsForm() {
        return "pages/operations";
    }
}

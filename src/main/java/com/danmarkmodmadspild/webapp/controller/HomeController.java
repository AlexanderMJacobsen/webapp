package com.danmarkmodmadspild.webapp.controller;

import com.danmarkmodmadspild.webapp.FoodItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    // In-memory “database” (hardcodet)
    private final List<FoodItem> items = new CopyOnWriteArrayList<>();

    public HomeController() {
        // id, name, category, qty, kg, price, pickup, desc
        items.add(new FoodItem(
                UUID.randomUUID().toString(), "Grøn salatboks", "vegansk",
                6, 2.5, 0.0,
                LocalDateTime.now().plusHours(2), "Indeholder nødder"));

        items.add(new FoodItem(
                UUID.randomUUID().toString(), "Vegetarisk lasagne stykker", "vegetarisk",
                4, 1.8, 15.0,
                LocalDateTime.now().plusHours(5), "Med ost (gluten)"));

        items.add(new FoodItem(
                UUID.randomUUID().toString(), "Blandede brød (daggammelt)", "andet",
                10, 3.0, 0.0,
                null, "Rugbrød + boller"));
    }

    @GetMapping("/")
    public String home(
            @RequestParam(name = "category", required = false) List<String> categories,
            @RequestParam(name = "q", required = false) String q,
            Model model
    ) {
        // Brug en "effectively final" liste til streams
        List<String> activeCategories = (categories == null || categories.isEmpty())
                ? Arrays.asList("vegansk", "vegetarisk", "andet")
                : categories;

        String query = Optional.ofNullable(q).orElse("").trim().toLowerCase();

        List<FoodItem> filtered = items.stream()
                .filter(i -> activeCategories.contains(i.getCategory()))
                .filter(i -> query.isEmpty()
                        || i.getName().toLowerCase().contains(query)
                        || Optional.ofNullable(i.getDesc()).orElse("").toLowerCase().contains(query))
                .collect(Collectors.toList());

        model.addAttribute("items", filtered);
        model.addAttribute("count", filtered.size());
        model.addAttribute("activeCategories", activeCategories);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("form", new FoodItem()); // tom form til "opret"
        return "BusinessFoodManage";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable String id,
            @RequestParam(name = "category", required = false) List<String> categories,
            @RequestParam(name = "q", required = false) String q,
            Model model
    ) {
        FoodItem item = items.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (item == null) return "redirect:/";

        List<String> activeCategories = (categories == null || categories.isEmpty())
                ? Arrays.asList("vegansk", "vegetarisk", "andet")
                : categories;

        model.addAttribute("items", items);
        model.addAttribute("count", items.size());
        model.addAttribute("activeCategories", activeCategories);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("form", item); // forfyld form
        return "BusinessFoodManage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") FoodItem form) {
        // Simple defaults/validering
        if (form.getQty() == null || form.getQty() < 1) form.setQty(1);
        if (form.getKg() == null || form.getKg() < 0) form.setKg(0.0);
        if (form.getPrice() == null || form.getPrice() < 0) form.setPrice(0.0);

        if (form.getId() == null || form.getId().isBlank()) {
            // Opret
            form.setId(UUID.randomUUID().toString());
            items.add(0, form);
        } else {
            // Opdater
            items.replaceAll(i -> i.getId().equals(form.getId()) ? form : i);
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        items.removeIf(i -> i.getId().equals(id));
        return "redirect:/";
    }
}

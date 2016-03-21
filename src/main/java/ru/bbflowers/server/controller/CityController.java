package ru.bbflowers.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bbflowers.server.entity.Category;
import ru.bbflowers.server.entity.City;
import ru.bbflowers.server.repository.CategoryRepository;
import ru.bbflowers.server.repository.CityRepository;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<City> getCategory() {
        List<City> list = cityRepository.findAll();
        Collections.sort(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public City handler(@PathVariable("id") long id) {
        City category = cityRepository.findOne(id);
        return category;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getCategoty(Model model) {
        List<City> list = cityRepository.findAll();
        model.addAttribute("cities", list);
        model.addAttribute("title", "Спсиок городов");
        return "cities";
    }
}

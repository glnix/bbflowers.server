package ru.bbflowers.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bbflowers.server.entity.Category;
import ru.bbflowers.server.repository.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Category> getCategory() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }


    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category handler(@PathVariable("id") long id) {
        Category category = categoryRepository.findOne(id);
        return category;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getCategoty(Model model) {
        List<Category> list = categoryRepository.findAll();
        model.addAttribute("categories", list);
        model.addAttribute("title", "Спсиок категорий");
        return "category";
    }

}

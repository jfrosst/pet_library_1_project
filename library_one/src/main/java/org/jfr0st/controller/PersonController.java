package org.jfr0st.controller;

import org.jfr0st.dao.PersonDao;
import org.jfr0st.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String getAllPersonFromBase(Model model){
        model.addAttribute("person", personDao.getAllPerson());
        return "person/all_person";
    }
    @GetMapping("/new")
    public String addNewPerson(@ModelAttribute("person") Person person){
        return "person/new";
    }

    @PostMapping
    public String savePerson(@ModelAttribute("person") Person person){
        personDao.create(person);
        return "redirect:/person";
    }

}

package org.jfr0st.controller;

import org.jfr0st.dao.PersonDao;
import org.jfr0st.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String getAllPersonFromBase(Model model) {
        model.addAttribute("person", personDao.getAllPerson());
        return "person/all_person";
    }

    @GetMapping("/show/{id}")
    public String showPerson(Model model, @PathVariable int id) {
        model.addAttribute("person", personDao.getPerson(id));
        return "person/show";
    }

    @GetMapping("/new")
    public String addNewPerson(@ModelAttribute("person") Person person) {
        return "person/new";
    }

    @PostMapping
    public String savePerson(@ModelAttribute("person") Person person) {
        personDao.create(person);
        return "redirect:/person";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDao.getPerson(id));
        return "person/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute Person person,  @PathVariable("id") int id){
        personDao.update(person, id);
        return "redirect:/person";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personDao.delete(id);
        return "redirect:/person";
    }

}

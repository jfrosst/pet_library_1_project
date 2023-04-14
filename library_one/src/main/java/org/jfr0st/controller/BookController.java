package org.jfr0st.controller;

import org.jfr0st.dao.BookDao;
import org.jfr0st.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping
    public String showAllBook(Model model){
        model.addAttribute("book", bookDao.getAll());
        return "book/all_book";
    }

    @GetMapping("/new")
    public String addNewBook(@ModelAttribute("book") Book book) {
        return "book/new";
    }

    @PostMapping
    public String saveBook(@ModelAttribute("book") Book book){
        bookDao.create(book);
        return "redirect:/book";
    }



}

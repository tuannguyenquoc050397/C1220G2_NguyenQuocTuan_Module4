package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookCode;
import com.example.demo.service.BookCodeService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookCodeService bookCodeService;

//    @ModelAttribute("books")
//    public Page<Book> books(Pageable ){
//        return bookService.findAll()
//    }

    @GetMapping
    public ModelAndView showBooks(@PageableDefault(value = 3) Pageable pageable) {

        return new ModelAndView("list", "books", bookService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "book", new Book());
    }

    @PostMapping("/create")
    public ModelAndView create(Book book, @PageableDefault(value = 3) Pageable pageable) {
        bookService.save(book);
        return new ModelAndView("list", "books", bookService.findAll(pageable));

    }

    @GetMapping("/thuesach/{id}")
    public ModelAndView thueSach(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book.getUnit() > 0) {
            Optional<BookCode> bookCode;

            long code;
            do {
                code = (long) (Math.random() * 100000);
                bookCode = bookCodeService.findByCode(code);

            } while (bookCode.isPresent());

            book.setUnit(book.getUnit() - 1);
            bookService.save(book);
            BookCode bookCode1 = new BookCode();
            bookCode1.setBook(book);
            bookCode1.setCode(code);
            bookCodeService.save(bookCode1);
            ModelAndView modelAndView = new ModelAndView("book");
            modelAndView.addObject("code", code);

            return modelAndView;
        } else {
            return new ModelAndView("error");
        }

    }

    @GetMapping("/trasach")
    public ModelAndView traSach() {
        return new ModelAndView("return_book");
    }

    @PostMapping("/trasach")
    public ModelAndView traSach(@RequestParam String code) {

        long codeLong = Long.parseLong(code);

        Optional<BookCode> bookCode = bookCodeService.findByCode(codeLong);
        if (bookCode.isPresent()) {
            int unit = bookCode.get().getBook().getUnit();
            bookCode.get().getBook().setUnit(unit + 1);


            bookCodeService.deleteByCode(codeLong);


            return new ModelAndView("book", "code", false);
        } else {
            return new ModelAndView("error");
        }

    }

}

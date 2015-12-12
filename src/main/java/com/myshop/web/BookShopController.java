package com.myshop.web;

import com.myshop.book.Book;
import com.myshop.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Kot on 12.12.15.
 */
@RestController()
@RequestMapping("/shop")
public class BookShopController {

    private BookShopService bookShop;

    @Autowired
    public BookShopController(BookShopService bookShop) {
        this.bookShop = bookShop;
    }

    @RequestMapping(value = "/books/", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Book>> items() {

        List<Book> books = bookShop.bookList();
        if(books == null) {
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }


    @RequestMapping(value = "/book/", method = RequestMethod.POST)
    public ResponseEntity<Void> addNewBook(@RequestBody Book book, UriComponentsBuilder builder){

        if(bookShop.isBookExist(book)){
            new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        bookShop.addBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

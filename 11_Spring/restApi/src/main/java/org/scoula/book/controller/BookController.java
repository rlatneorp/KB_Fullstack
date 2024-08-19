package org.scoula.book.controller;

import org.scoula.book.dto.BookDto;
import org.scoula.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService service;

    @GetMapping("")
    public ResponseEntity<List<BookDto>> getList() {
        return ResponseEntity.ok(service.getList());
    }

}

package org.scoula.book.service;

import org.scoula.book.dto.BookDto;

import java.util.List;

public interface BookService {
    public List<BookDto> getList();

    public BookDto get(Integer id);

    public BookDto create(BookDto book);

    public BookDto update(BookDto book);

    public BookDto delete(Integer id);

}

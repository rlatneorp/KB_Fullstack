package org.scoula.book.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Override
    public List<BookDto> getList() {
        return List.of();
    }

    @Override
    public BookDto get(Integer id) {
        return null;
    }

    @Override
    public BookDto create(BookDto book) {
        return null;
    }

    @Override
    public BookDto update(BookDto book) {
        return null;
    }

    @Override
    public BookDto delete(Integer id) {
        return null;
    }
}

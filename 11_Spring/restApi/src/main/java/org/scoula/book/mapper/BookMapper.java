package org.scoula.book.mapper;

import org.scoula.book.dto.BookDto;

import java.util.List;

public interface BookMapper {

    public List<BookDto> getList();

    public BookDto get(Integer id);

    public void create(BookDto book);

    public int update(BookDto book);

    public int delete(Integer id);
}

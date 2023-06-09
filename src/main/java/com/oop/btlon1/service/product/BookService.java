package com.oop.btlon1.service.product;

import com.oop.btlon1.entity.product.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllWithPage(int page);
    List<Book> getAll();
    Book getOneById(String id);
    boolean save(Book book);
    boolean update(Book book);

    Book getOneByName(String name);

    boolean deleteOneById(String id);
}

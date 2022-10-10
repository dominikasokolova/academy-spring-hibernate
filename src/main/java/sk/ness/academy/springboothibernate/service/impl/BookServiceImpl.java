package sk.ness.academy.springboothibernate.service.impl;

import org.springframework.stereotype.Service;
import sk.ness.academy.springboothibernate.dao.BookDao;
import sk.ness.academy.springboothibernate.dto.BookDto;
import sk.ness.academy.springboothibernate.model.Book;
import sk.ness.academy.springboothibernate.service.BookService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Resource
  private BookDao bookDao;

  @Override
  public List<BookDto> findAll() {
    final List<Book> books = bookDao.findAll();
    return null == books ? new ArrayList<>() :
        books.stream()
            .map(book -> new BookDto("X_" + book.getName()))
            .collect(Collectors.toList());
  }

  @Override
  public void save(final Book book) {
    bookDao.persist(book);
  }

}

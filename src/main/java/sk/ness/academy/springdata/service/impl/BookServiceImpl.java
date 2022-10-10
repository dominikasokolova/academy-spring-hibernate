package sk.ness.academy.springdata.service.impl;

import org.springframework.stereotype.Service;
import sk.ness.academy.springdata.model.Book;
import sk.ness.academy.springdata.repository.BookRepository;
import sk.ness.academy.springdata.service.BookService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Resource
  private BookRepository bookRepository;

  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public void save(final Book book) {
    bookRepository.save(book);
  }

}

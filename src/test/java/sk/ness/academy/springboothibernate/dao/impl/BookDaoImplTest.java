package sk.ness.academy.springboothibernate.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.yaml.snakeyaml.tokens.Token;
import sk.ness.academy.config.TestDataSourceConfig;
import sk.ness.academy.springboothibernate.dao.BookDao;
import sk.ness.academy.springboothibernate.model.Book;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = { TestDataSourceConfig.class, BookDaoImpl.class })
@Transactional
@Sql({"/initdb.sql"})
class BookDaoImplTest {

  @Autowired
  private BookDao bookDao;

  @BeforeEach
  public void beforeEach() {
    System.out.println("### BeforeEach ###");
  }

  @Test
  public void contextLoads() throws Exception {
    Assertions.assertNotEquals(bookDao, null);
  }

  @Test
  void findAllTest() {
    final List<Book> books = bookDao.findAll();
    Assertions.assertEquals(3, books.size());
  }

  @Test
  void persistTest() {
    List<Book> booksBefore = bookDao.findAll();

    Book book = new Book();
    book.setName("This is book title");
    bookDao.persist(book);

    List<Book> booksAfter = bookDao.findAll();

    Assertions.assertEquals(book.getName(), booksAfter.get(0).getName());
    Assertions.assertEquals(booksBefore.size() + 1, booksAfter.size());
  }

}
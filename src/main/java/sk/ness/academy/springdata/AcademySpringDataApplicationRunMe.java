package sk.ness.academy.springdata;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;
import sk.ness.academy.springdata.model.Book;
import sk.ness.academy.springdata.service.BookService;

import java.util.List;

@Component
public class AcademySpringDataApplicationRunMe {

  private final BookService bookService;

  public AcademySpringDataApplicationRunMe(final BookService bookService) {
    this.bookService = bookService;
  }

  public void run() {

    final Book book = new Book();
    book.setName(RandomString.make());
    bookService.save(book);

    final List<Book> books = bookService.findAll();
    books.forEach(System.out::println);
  }
}

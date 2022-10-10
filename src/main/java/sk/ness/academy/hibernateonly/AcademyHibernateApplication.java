package sk.ness.academy.hibernateonly;

import net.bytebuddy.utility.RandomString;
import sk.ness.academy.hibernateonly.model.Book;
import sk.ness.academy.hibernateonly.repository.impl.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcademyHibernateApplication {

  public static void main(final String[] args) throws InterruptedException {

    final EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("sk.ness.jpa");

    final EntityManager entityManager = entityManagerFactory.createEntityManager();
    final BookRepository bookRepository = new BookRepository(entityManager);

    Book book = null;
    book = bookRepository.read(Book.class, 1L);
    System.out.println(book);

    book.setName("new namee");
    //    newBook.setId(1000L);
    bookRepository.update(book);

    book = null;
    book = bookRepository.read(Book.class, 1L);
    System.out.println(book);

    bookRepository.create(new Book(RandomString.make()));

    bookRepository.close();

  }

}

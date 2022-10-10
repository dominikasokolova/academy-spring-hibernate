package sk.ness.academy.hibernateonly.repository.impl;

import org.springframework.stereotype.Repository;
import sk.ness.academy.hibernateonly.repository.CrudRepository;
import sk.ness.academy.hibernateonly.model.Book;

import javax.persistence.EntityManager;

@Repository
public class BookRepository implements CrudRepository<Book> {

  private EntityManager entityManager;

  public BookRepository(final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void create(final Book entity) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(entity);
      entityManager.getTransaction().commit();
    } catch (final Exception e) {
      try {
        System.out.println(e.getMessage());
        entityManager.getTransaction().rollback();
      } catch (final Exception e1) {
        // rollback failed :/
      }
    }
  }

  @Override
  public Book read(final Class<Book> entityClass, final Object id) {
    entityManager.getTransaction().begin();
    final Book book = entityManager.find(entityClass, id);
    entityManager.getTransaction().commit();
    return book;
  }

  @Override
  public Book update(final Book entity) {
    entityManager.getTransaction().begin();
    final Book book = entityManager.merge(entity);
    entityManager.getTransaction().commit();
    return book;
  }

  @Override
  public void delete(final Book entity) {
    entityManager.getTransaction().begin();
    entityManager.remove(entity);
    entityManager.getTransaction().commit();
  }

  @Override
  public void close() {
    entityManager.getTransaction().begin();
    entityManager.createNativeQuery("SHUTDOWN").executeUpdate();
//    entityManager.flush();
    entityManager.getTransaction().commit();
  }
}

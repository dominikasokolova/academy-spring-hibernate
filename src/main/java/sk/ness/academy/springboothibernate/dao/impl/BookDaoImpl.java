package sk.ness.academy.springboothibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sk.ness.academy.springboothibernate.dao.BookDao;
import sk.ness.academy.springboothibernate.model.Book;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  @Override
  public List<Book> findAll() {
    return this.sessionFactory.getCurrentSession().createQuery("select b from Book b", Book.class).getResultList();
  }

  @Override
  public void persist(final Book book) {
    this.sessionFactory.getCurrentSession().persist(book);
  }

}

package sk.ness.academy.springboothibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
  @GeneratedValue
  private Long id;

  @Column(name = "name", length = 250)
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Book{" + "id=" + id + ", name='" + name + "'}";
  }
}

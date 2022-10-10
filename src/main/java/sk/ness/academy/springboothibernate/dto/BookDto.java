package sk.ness.academy.springboothibernate.dto;

import java.util.Objects;

public class BookDto {

  private String name;

  public BookDto(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o)
      return true;
    if (!(o instanceof BookDto))
      return false;
    final BookDto bookDto = (BookDto) o;
    return Objects.equals(getName(), bookDto.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "BookDto{" + "name='" + name + "'}";
  }
}

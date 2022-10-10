package sk.ness.academy.hibernateonly.repository;

public interface CrudRepository<T> {
  void create(T entity);

  T read(Class<T> entityClass, Object id);

  T update(T entity);

  void delete(T entity);

  void close();
}

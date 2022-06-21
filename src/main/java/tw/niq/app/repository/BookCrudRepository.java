package tw.niq.app.repository;

import java.awt.print.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book, Long> {

}

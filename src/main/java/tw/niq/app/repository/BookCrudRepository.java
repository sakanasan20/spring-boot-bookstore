package tw.niq.app.repository;



import org.springframework.data.repository.CrudRepository;

import tw.niq.app.domain.Book;

public interface BookCrudRepository extends CrudRepository<Book, Long> {

}

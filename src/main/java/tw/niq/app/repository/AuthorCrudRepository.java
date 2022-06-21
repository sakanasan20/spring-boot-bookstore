package tw.niq.app.repository;

import org.springframework.data.repository.CrudRepository;

import tw.niq.app.domain.Author;

public interface AuthorCrudRepository extends CrudRepository<Author, Long> {

}

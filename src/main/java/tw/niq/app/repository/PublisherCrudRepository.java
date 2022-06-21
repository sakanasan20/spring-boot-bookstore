package tw.niq.app.repository;



import org.springframework.data.repository.CrudRepository;

import tw.niq.app.domain.Publisher;

public interface PublisherCrudRepository extends CrudRepository<Publisher, Long> {

}

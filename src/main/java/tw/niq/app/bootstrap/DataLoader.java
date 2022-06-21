package tw.niq.app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tw.niq.app.domain.Author;
import tw.niq.app.domain.Book;
import tw.niq.app.domain.Publisher;
import tw.niq.app.repository.AuthorCrudRepository;
import tw.niq.app.repository.BookCrudRepository;
import tw.niq.app.repository.PublisherCrudRepository;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

	private final AuthorCrudRepository authorCrudRepository;
	private final BookCrudRepository bookCrudRepository;
	private final PublisherCrudRepository publisherCrudRepository;

	public DataLoader(AuthorCrudRepository authorCrudRepository, BookCrudRepository bookCrudRepository,
			PublisherCrudRepository publisherCrudRepository) {
		this.authorCrudRepository = authorCrudRepository;
		this.bookCrudRepository = bookCrudRepository;
		this.publisherCrudRepository = publisherCrudRepository;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		
		publisher.setName("SFG Publishing");
		publisher.setCity("St Pertersburg");
		publisher.setState("FL");
		
		publisherCrudRepository.save(publisher);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "00000001");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorCrudRepository.save(eric);
		bookCrudRepository.save(ddd);
		publisherCrudRepository.save(publisher);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "00000002");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorCrudRepository.save(rod);
		bookCrudRepository.save(noEJB);
		publisherCrudRepository.save(publisher);
		
		log.info("Authors loadded: " + authorCrudRepository.count());
		log.info("Books loadded: " + bookCrudRepository.count());
		log.info("Publisher loadded: " + publisherCrudRepository.count());
		log.info("Publisher books loaded: " + publisher.getBooks().size());
		
	}

}

package tw.niq.app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tw.niq.app.domain.Author;
import tw.niq.app.domain.Book;
import tw.niq.app.repository.AuthorCrudRepository;
import tw.niq.app.repository.BookCrudRepository;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

	private final AuthorCrudRepository authorCrudRepository;
	private final BookCrudRepository bookCrudRepository;
	
	public DataLoader(AuthorCrudRepository authorCrudRepository, BookCrudRepository bookCrudRepository) {
		this.authorCrudRepository = authorCrudRepository;
		this.bookCrudRepository = bookCrudRepository;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "00000001");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorCrudRepository.save(eric);
		bookCrudRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "00000002");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorCrudRepository.save(rod);
		bookCrudRepository.save(noEJB);
		
		log.info("Authors loadded: " + authorCrudRepository.count());
		log.info("Books loadded: " + bookCrudRepository.count());
		
	}

}

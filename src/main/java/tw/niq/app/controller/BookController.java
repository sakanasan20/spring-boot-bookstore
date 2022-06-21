package tw.niq.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.niq.app.repository.BookCrudRepository;

@Controller
@RequestMapping("/books")
public class BookController {

	private final BookCrudRepository bookCrudRepository;

	public BookController(BookCrudRepository bookCrudRepository) {
		this.bookCrudRepository = bookCrudRepository;
	}
	
	@GetMapping
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookCrudRepository.findAll());
		
		return "books/list";
	}
}

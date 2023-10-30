package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.BookServiceImpl;
/**
*@author Henry Weber 
*@version 1.0
* The Book Controller class
*/

@CrossOrigin // @CrossOrigin is used in web service so it will include CORS access control headers in its response
@RestController // @RestController is a combination of @Controller and @ResponseBody. It converts the response to JSON or XML.
@RequestMapping("book") // Used to map a request path to a controller and/or method.
public class BookController {

	@Autowired
	private final BookService bookService;
	
	/**Constructor for the BookController class
	 * 
	 * @param BookService object
	 */
	private BookController(BookService service) {
		this.bookService = service;
	}
	/**Adds Book object to the database, returns the Book that was added
	 * 
	 * @param Book object
	 * @return Book object
	 */
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	/**Adds List of Book objects to the database, returns the List of Book objects
	 * 
	 * @param List of Book objects
	 * @return List of Book objects
	 */
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books) {
		return bookService.saveBooks(books);
	}
	/**Returns List of Book objects from the database
	 * 
	 * @return List of Book objects
	 */
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return bookService.getBooks();
	}
	/**Returns Book object given id
	 * 
	 * @param id of the book
	 * @return Book object
	 */	
	@GetMapping("/bookById/{id}")
	public Book findBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}
	/**Returns Book object given title
	 * 
	 * @param title of the book
	 * @return Book object
	 */
	@GetMapping("/bookByTitle/{title}")
	public Book findBookByTitle(@PathVariable String title) {
		return bookService.getBookByTitle(title);
	}
	/**Returns Book object given author
	 * 
	 * @param author of the book
	 * @return Book object
	 */
	@GetMapping("/bookByAuthor/{author}")
	public Book findBookByAuthor(@PathVariable String author) {
		return bookService.getBookByAuthor(author);
	}
	/**Returns Book object given publisher
	 * 
	 * @param publisher of the book
	 * @return Book object
	 */
	@GetMapping("/bookByPublisher/{publisher}")
	public Book findBookByPublisher(@PathVariable String publisher) {
		return bookService.getBookByPublisher(publisher);
	}
	/**Update Book with the given id
	 * 
	 * @param book_id of the book to update
	 * @return Book object that was updated
	 */
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	/**Delete Book with given id
	 * 
	 * @param id of the book to delete
	 * @return Book object that has been deleted
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
}
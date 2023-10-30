package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

/**
*@author Henry Weber 
*@version 1.0
* The Book Service interface
*/
@Service
public interface BookService {

	/**Saves Book object, returns the Book object
	 * 
	 * @param Book object
	 * @return Book object
	 */
	public Book saveBook(Book book);
	
	/**Saves List of Book objects, returns the List of Book objects
	 * 
	 * @param List of Book objects
	 * @return List of Book objects
	 */
	public List<Book> saveBooks(List<Book> books);
	
	/**Returns List of Book objects
	 * 
	 * @return List of Book objects
	 */
	public List<Book> getBooks();
	
	/**Returns Book object
	 * 
	 * @param id of the book
	 * @return Book object
	 */
	public Book getBookById(int id);
	
	/**Returns Book object
	 * 
	 * @param title of the book
	 * @return Book object
	 */
	public Book getBookByTitle(String title);
	
	/**Returns Book object
	 * 
	 * @param author of the book
	 * @return Book object
	 */
	public List<Book> getBookByAuthor(String author);
	
	/**Returns Book object
	 * 
	 * @param publisher of the book
	 * @return Book object
	 */
	public List<Book> getBookByPublisher(String publisher);
	
	/**Delete Book with given id
	 * 
	 * @param id of the book to delete
	 */
	public String deleteBook(int id);
	
	/**Update Book with the given id
	 * 
	 * @param id of the book to update
	 */
	public Book updateBook(Book book);
	
	
	


	
	

}
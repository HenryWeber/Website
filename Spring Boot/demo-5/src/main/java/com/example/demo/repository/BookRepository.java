package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Book;
/**
*@author Henry Weber 
*@version 1.0
* The Book Repository interface
*/
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	/**Gets the Book object 
	 * 
	 * @param Book object
	 * @return Book object
	 */
	Book findById(Book book);
	/**Gets the Book object when given the book title
	 * 
	 * @param title String of the book
	 * @return Book object
	 */
	Book findByTitle(String title);
	/**Gets the Book object when given the authors's name
	 * 
	 * @param author String of the book
	 * @return Book object
	 */
	Book findByAuthor(String author);
	/**Gets the Book object when given the publisher's name
	 * 
	 * @param publisher String of the book
	 * @return Book object
	 */
	Book findByPublisher(String publisher);
	
}

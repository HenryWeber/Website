package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

/**
*@author Henry Weber 
*@version 1.0
* The BookServiceImpl class
*/
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private final BookRepository repo;
	
	/**Constructor for the BookServiceImpl class
	 * 
	 * @param BookRepository object
	 */
	public BookServiceImpl(BookRepository repo){
		this.repo = repo;
	}
	public Book saveBook(Book book) {
		return repo.save(book);
	}
	public List<Book> saveBooks(List<Book> books) {
		return repo.saveAll(books);
	}
	public List<Book> getBooks() {
		return repo.findAll();
	}
	public Book getBookById(int book_id) {
		return repo.findById(book_id).orElse(null);
	}
	public Book getBookByTitle(String title) {
		return repo.findByTitle(title);
	}
	public Book getBookByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	public Book getBookByPublisher(String publisher) {
		return repo.findByPublisher(publisher);
	}
	
	public String deleteBook(int id) {
		repo.deleteById(id);
		return "Book removed: "+id;
	}
	
	public Book updateBook(Book book) {
		Book currentBook = repo.findById(book.getId()).orElse(null);
		
		//List fields to be set
		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setPublisher(book.getPublisher());
		currentBook.setPages(book.getPages());
		currentBook.setPublicationDate(book.getPublicationDate());	
				return repo.save(currentBook);
	}
	
}
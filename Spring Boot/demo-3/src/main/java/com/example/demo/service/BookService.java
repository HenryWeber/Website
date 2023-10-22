package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.controller.BookController;


@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	//SET
	public Book saveBook(Book book) {
		return repo.save(book);
	}
	
	public List<Book> saveBooks(List<Book> books) {
		return repo.saveAll(books);
	}
	
	//GET
	public List<Book> getBooks() {
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		return repo.findById(id).orElse(null);
	}
	public Book getBookByTitle(String title) {
		return repo.findByTitle(title);
	}
	public Book getBookByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	
	//DELETE
	public String deleteBook(int id) {
		repo.deleteById(id);
		return "Book removed: "+id;//+(repo.findById(id)).toString();
	}
	//UPDATE
	
	public Book updateBook(Book book) {
		Book currentBook = repo.findById(book.getId()).orElse(null);
		//List properties to be set
		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		return repo.save(currentBook);
	}


	
	

}

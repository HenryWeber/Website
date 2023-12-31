package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
*@author Henry Weber 
*@version 1.0
* The Book class
*/
@Data
@AllArgsConstructor
@Entity
@Table(name="book")
public class Book {

	/**The unique Book object's id that is auto-generated by the database
	 * 
	 */
	@Column(name="book_id")
	@Id
	@GeneratedValue
	private int id;
	
	/**The Book object's title
	 * 
	 */
	@Column(name="title")
	private String title;
	/**The Book object's author
	 * 
	 */	
	@Column(name="author")
	private String author;
	/**The Book object's publisher
	 * 
	 */
	@Column(name="publisher")
	private String publisher;
	/**The Book object's page count
	 * 
	 */
	@Column(name="pages")
	int pages;
	/**The Book object's date of publication(in JsonFormat)
	 * 
	 */
	@Column(name="publication_date")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	String publicationDate;
	
	/**Gets publisher of Book
	 * @return publisher of Book
	 */
	public String getPublisher() {
		return publisher;
	}
	/**Sets publisher of Book 
	 * @param publisher of Book
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**Gets pages of Book
	 * @return pages of Book
	 */
	public int getPages() {
		return pages;
	}
	/**Sets pages of Book
	 * @param pages of Book
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}
	/**Gets publicationDate of Book
	 * @return publicationDate of Book
	 */
	public String getPublicationDate() {
		return publicationDate;
	}
	/**Sets publicationDate of Book 
	 * @param publicationDate of Book
	 */
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	/**Gets author of Book
	 * @return author of Book
	 */
	public String getAuthor() {
		return author;
	}
	/**Sets author of Book
	 * @param author of Book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**Gets id of Book
	 * @return id of Book
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	/**Sets id of Book 
	 * @param id of Book
	 */
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	/**Gets title of Book
	 * @return title of Book
	 */
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	/**Sets title of Book 
	 * @param title of Book
	 */
	public void setTitle(String title) {
		this.title = title;
		
	}


	
}

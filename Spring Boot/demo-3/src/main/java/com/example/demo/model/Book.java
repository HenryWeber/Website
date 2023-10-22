package com.example.demo.model;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	private String author;
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
/*	public void setId(int id) {
		this.id = id;
		
	}*/
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
		
	}

	
}

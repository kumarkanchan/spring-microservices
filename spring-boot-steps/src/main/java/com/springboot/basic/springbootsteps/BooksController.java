package com.springboot.basic.springbootsteps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@GetMapping("/books")
	public List<Book> getAllBooks() {

		return Arrays.asList(new Book(1L, "Master in Microservices", "Vikas Rathore"));
	}

}

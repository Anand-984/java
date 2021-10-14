package com.ashokit.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private Integer bookId;
	private String isbn;
	private String bookName;
	private Double bookPrice;
	
	
}

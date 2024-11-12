package com.hoteles.infraestructure.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelRequest {

	private String name;
	private String category;
	private double price;
	private String available;
	private String image;
}
package com.hoteles.infraestructure.mapper;

import java.time.Instant;

import com.hoteles.domain.model.Hotel;
import com.hoteles.infraestructure.entity.HotelEntity;

public final class HotelDboMapper {

	public static Hotel toHotel(HotelEntity hotel) {
		return Hotel.builder()
				.id(hotel.getId())
				.name(hotel.getName())
				.category(hotel.getCategory())
				.available(hotel.getAvailable())
				.price(hotel.getPrice())
				.build();
	}

	public static HotelEntity toHotelEntity(Hotel hotel) {
		return HotelEntity.builder()
				.id(hotel.getId())
				.name(hotel.getName())
				.category(hotel.getCategory())
				.available(hotel.getAvailable())
				.price(hotel.getPrice())
				.createdAt(Instant.now())
				.build();
	}
}
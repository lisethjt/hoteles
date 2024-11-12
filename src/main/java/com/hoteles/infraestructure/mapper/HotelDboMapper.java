package com.hoteles.infraestructure.mapper;

import java.time.Instant;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.hoteles.domain.constant.HotelConstant;
import com.hoteles.domain.model.Hotel;
import com.hoteles.infraestructure.entity.HotelEntity;
import com.hoteles.infraestructure.exception.HotelException;

public final class HotelDboMapper {

	public static Hotel toHotel(HotelEntity hotel) {
		return Hotel.builder()
				.id(hotel.getId())
				.name(hotel.getName())
				.category(hotel.getCategory())
				.available(hotel.getAvailable())
				.price(hotel.getPrice())
				.image(hotel.getImage())
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
				.image(hotel.getImage())
				.build();
	}

	public static Hotel toHotel(Optional<HotelEntity> hotel) {
		if (!hotel.isPresent()) {
			hotel.orElseThrow(
					() -> new HotelException(HttpStatus.BAD_REQUEST, HotelConstant.HOTEL_NOT_FOUND_MESSAGE_ERROR));
		}
		return toHotel(hotel.get());
	}
}
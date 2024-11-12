package com.hoteles.infraestructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hoteles.domain.model.Hotel;
import com.hoteles.domain.port.HotelRepository;
import com.hoteles.infraestructure.mapper.HotelDboMapper;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

	private HotelJpaRepository hotelRepository;

	public HotelRepositoryImpl(HotelJpaRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		return HotelDboMapper.toHotel(hotelRepository.save(HotelDboMapper.toHotelEntity(hotel)));
	}

	@Override
	public List<Hotel> getByName(String name) {
		return hotelRepository.findByName(name).stream().map(HotelDboMapper::toHotel).collect(Collectors.toList());
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll().stream().map(HotelDboMapper::toHotel).collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public Hotel update(Hotel hotel) {
		return HotelDboMapper.toHotel(hotelRepository.save(HotelDboMapper.toHotelEntity(hotel)));
	}

	@Override
	public Hotel findById(Long id) {
		return HotelDboMapper.toHotel(hotelRepository.findById(id));
	}
}

package com.hoteles.infraestructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoteles.infraestructure.entity.HotelEntity;

public interface HotelJpaRepository extends JpaRepository<HotelEntity, Long> {

	List<HotelEntity> findByName(String name);

}
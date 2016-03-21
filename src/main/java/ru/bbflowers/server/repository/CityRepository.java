package ru.bbflowers.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bbflowers.server.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}

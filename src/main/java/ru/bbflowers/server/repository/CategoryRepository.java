package ru.bbflowers.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bbflowers.server.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

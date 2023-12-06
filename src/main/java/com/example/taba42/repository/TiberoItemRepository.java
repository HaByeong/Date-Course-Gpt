package com.example.taba42.repository;

import com.example.taba42.entity.TiberoItem;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TiberoItemRepository extends JpaRepository<TiberoItem, Long> {
}

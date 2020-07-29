package com.learn.amigoscode.repository;

import com.learn.amigoscode.entity.Perpustakaan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PerpustakaanRepository extends PagingAndSortingRepository<Perpustakaan, String> {
}

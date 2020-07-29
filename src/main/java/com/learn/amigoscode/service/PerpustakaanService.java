package com.learn.amigoscode.service;

import com.learn.amigoscode.entity.Perpustakaan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PerpustakaanService {
    Page<Perpustakaan> getAll(Pageable pageable);
    Perpustakaan getById(String id) throws Exception;
    Perpustakaan save(Perpustakaan parkir);
    void delete(String id);
}
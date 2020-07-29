package com.learn.amigoscode.service.impl;

import com.learn.amigoscode.entity.Perpustakaan;
import com.learn.amigoscode.repository.PerpustakaanRepository;
import com.learn.amigoscode.service.PerpustakaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PerpustakaanRepositoryImpl implements PerpustakaanService {

   @Autowired
   private PerpustakaanRepository repository;

    @Override
    public Page<Perpustakaan> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Perpustakaan getById(String id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID NOT FOUND"));
    }

    @Override
    public Perpustakaan save(Perpustakaan parkir) {
        return repository.save(parkir);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
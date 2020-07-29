package com.learn.amigoscode.controller;

import com.learn.amigoscode.dto.PerpustakaanDto;
import com.learn.amigoscode.entity.Perpustakaan;
import com.learn.amigoscode.service.PerpustakaanService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PerpustakaanController {

    @Autowired
    private PerpustakaanService perpustakaanService;
    private ModelMapper modelMapper;

    @Autowired
    public PerpustakaanController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(skipModifiedFieldsMap);
    }

    private PropertyMap<Perpustakaan, PerpustakaanDto> skipModifiedFieldsMap = new PropertyMap<Perpustakaan, PerpustakaanDto>() {
        @Override
        protected void configure() {
            skip().setTanggalCreated(null);
        }
    };

    @PostMapping("/perpustakaans")
    @ResponseStatus(HttpStatus.CREATED)
    public PerpustakaanDto simpan(@RequestBody PerpustakaanDto perpustakaan) {
       Perpustakaan perpustakaan1 = modelMapper.map(perpustakaan, Perpustakaan.class);
       perpustakaan.setTanggalCreated(new Date());
       Perpustakaan save = perpustakaanService.save(perpustakaan1);
       perpustakaan.setId(save.getId());
       perpustakaan.setTanggalCreated(save.getTanggalCreated());
       return perpustakaan;
    }

    @GetMapping("/perpustakaans")
    public Page<PerpustakaanDto> getAll(Pageable pageable) {
        Page<Perpustakaan> all = perpustakaanService.getAll(pageable);
        List<Perpustakaan> content = all.getContent();
        List<PerpustakaanDto> perpustakaanDtos = new ArrayList<>();
        for (Perpustakaan perpustakaan : content) {
            PerpustakaanDto dto = modelMapper.map(perpustakaan, PerpustakaanDto.class);
            dto.setTanggalCreated(perpustakaan.getTanggalCreated());
            perpustakaanDtos.add(dto);
        }
        return new PageImpl<>(perpustakaanDtos, pageable, all.getTotalElements());
    }

    @GetMapping("/perpustakaans/{id}")
    public PerpustakaanDto getById(@PathVariable("id") String id) {
        try {
            Perpustakaan perpustakaan = perpustakaanService.getById(id);
            PerpustakaanDto dto = modelMapper.map(perpustakaan, PerpustakaanDto.class);
            dto.setTanggalCreated(perpustakaan.getTanggalCreated());
            return dto;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @DeleteMapping("/perpustakaans")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
       perpustakaanService.delete(id);
    }

    @PatchMapping("/perpustakaans/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Perpustakaan perpustakaan, @PathVariable("id") String id) {
        try {
            Perpustakaan perpustakaan1 = perpustakaanService.getById(id);
            BeanUtils.copyProperties(perpustakaan, perpustakaan1);
            perpustakaan1.setId(id);
            perpustakaan1.setJudul(perpustakaan.getJudul());
            perpustakaan1.setPengarang(perpustakaan.getPengarang());
            perpustakaan1.setPenerbit(perpustakaan.getPenerbit());
            perpustakaan1.setStatus(perpustakaan.getStatus());
            perpustakaan1.setKodeBuku(perpustakaan.getKodeBuku());
            perpustakaan1.setSummary(perpustakaan.getSummary());
            perpustakaan1.setTanggalCreated(perpustakaan.getTanggalCreated());
            perpustakaan1.setTanggalTransaksi(perpustakaan.getTanggalTransaksi());
            perpustakaan1.setTanggalExpired(perpustakaan.getTanggalExpired());
            perpustakaanService.save(perpustakaan1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
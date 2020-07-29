package com.learn.amigoscode.service;

import com.learn.amigoscode.entity.Perpustakaan;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
public class PerpustakaanServiceTest {

    @Autowired
    private PerpustakaanService service;

    @Test
    void saveTest() {
        Perpustakaan perpustakaan = new Perpustakaan();
        perpustakaan.setJudul("belajar java");
        perpustakaan.setKodeBuku("0012");
        perpustakaan.setPenerbit("enersia");
        perpustakaan.setPengarang("Sammidev");
        perpustakaan.setStatus(true);
        perpustakaan.setTanggalCreated(new Date());
        perpustakaan.setTanggalTransaksi(new Date());
        Perpustakaan perpustakaan1 = service.save(perpustakaan);
    }

    @Test
    @Ignore
    void getAllTest() {
        try {
            Perpustakaan perpustakaan = service.getById("002");
            log.info(perpustakaan.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

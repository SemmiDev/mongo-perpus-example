package com.learn.amigoscode.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "perpustakaan")
public class Perpustakaan {

    @Id
    private String id;
    private String judul;
    private String pengarang;
    private String penerbit;
    private String kodeBuku;
    private Date tanggalTransaksi;
    private Date tanggalCreated;
    private Date tanggalExpired;
    private String summary;
    private Boolean status;
}

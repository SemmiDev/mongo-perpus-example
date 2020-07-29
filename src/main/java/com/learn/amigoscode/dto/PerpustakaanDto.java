package com.learn.amigoscode.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.learn.amigoscode.util.JsonDateTimesSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class PerpustakaanDto {
    private String id;
    private String judul;
    private String pengarang;
    private String penerbit;

    @JsonProperty("kode_buku")
    private String kodeBuku;

    @JsonProperty("tanggal_transaksi")
    @JsonDeserialize(using = JsonDateTimesSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tanggalTransaksi;

    @JsonProperty("tanggal_created")
    @JsonDeserialize(using = JsonDateTimesSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tanggalCreated;

    @JsonProperty("tanggal_expired")
    @JsonDeserialize(using = JsonDateTimesSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tanggalExpired;

    private String summary;
    private boolean status;
}
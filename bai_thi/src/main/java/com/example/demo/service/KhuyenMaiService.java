package com.example.demo.service;

import com.example.demo.model.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhuyenMaiService {

    Page<KhuyenMai> findAll(Pageable pageable);
    void deleteById(Integer id);
    KhuyenMai findById(Integer id);
    void save(KhuyenMai khuyenMai);
    Page<KhuyenMai> findSearch(Double mucGiamGia, String thoiGianBatDau, String thoiGianKetThuc, Pageable pageable);
}

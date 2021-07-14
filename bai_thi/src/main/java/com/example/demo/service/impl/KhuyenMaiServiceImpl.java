package com.example.demo.service.impl;

import com.example.demo.model.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public Page<KhuyenMai> findAll(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public KhuyenMai findById(Integer id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
    khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public Page<KhuyenMai> findSearch(Double mucGiamGia, String thoiGianBatDau, String thoiGianKetThuc, Pageable pageable) {
        return khuyenMaiRepository.findSearch(mucGiamGia,thoiGianBatDau,thoiGianKetThuc,pageable);
    }
}

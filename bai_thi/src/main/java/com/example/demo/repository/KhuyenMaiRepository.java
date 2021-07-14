package com.example.demo.repository;

import com.example.demo.model.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {

    Page<KhuyenMai> findAll(Pageable pageable);

    @Query(value = "select * " +
            "from khuyen_mai " +
            "where ( ?1 IS NULL  OR muc_giam_gia = ?1 ) " +
            "and thoi_gian_bat_dau like %?2% " +
            "and thoi_gian_ket_thuc like %?3% ", nativeQuery=true)
    Page<KhuyenMai> findSearch(Double mucGiamGia, String thoiGianBatDau, String thoiGianKetThuc, Pageable pageable);

}

package com.example.demo.ulti.validate;

import com.example.demo.model.KhuyenMai;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class KhuyenMaiValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KhuyenMai.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        KhuyenMai khuyenMai = (KhuyenMai) target;
        LocalDate localDate = LocalDate.now();
        if (!("".equals(khuyenMai.getThoiGianBatDau()))){
            LocalDate ngayBatDau = LocalDate.parse(khuyenMai.getThoiGianBatDau(),
                    DateTimeFormatter.ISO_LOCAL_DATE);
            boolean check = ngayBatDau.isAfter(localDate)||localDate.equals(ngayBatDau);
            if (!check){
                errors.rejectValue("thoiGianBatDau", "validate.date1");
            }
        }
        boolean checkString = ("".equals(khuyenMai.getThoiGianKetThuc())) || ("".equals(khuyenMai.getThoiGianBatDau()));
        if (!checkString){
            LocalDate ngayBatDau = LocalDate.parse(khuyenMai.getThoiGianBatDau(),
                    DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate ngayKetThuc = LocalDate.parse(khuyenMai.getThoiGianKetThuc(),
                    DateTimeFormatter.ISO_LOCAL_DATE);
            boolean check = ngayKetThuc.isAfter(ngayBatDau);
            if (!check){
                errors.rejectValue("thoiGianKetThuc", "validate.date2");
            }

        }

    }

    public static void main(String[] args) {

    }
}

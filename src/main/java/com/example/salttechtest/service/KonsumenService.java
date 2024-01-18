package com.example.salttechtest.service;

import com.example.salttechtest.dto.Konsumen;
import com.example.salttechtest.dto.KonsumenRequest;
import com.example.salttechtest.dto.KonsumenResponse;
import com.example.salttechtest.repository.IKonsumenRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("konsumenService")
public class KonsumenService {

    String pattern = "dd MMM yyyy";
    DateFormat df = new SimpleDateFormat(pattern);

    @Autowired
    @Qualifier("konsumenRepo")
    private IKonsumenRepo konsumenRepo;

    public List<KonsumenResponse> getMonitorData(KonsumenRequest req) {
        List<KonsumenResponse> listData = new ArrayList<>();
        try {
            List<Konsumen> getData = new ArrayList<>();
            if (req.getId().toString().equalsIgnoreCase("") || req.getId() == null) {
                getData = konsumenRepo.findAll();
            } else {
                Integer id = Integer.parseInt(req.getId());
                getData = konsumenRepo.getUserById(id);
            }

            for (Konsumen data : getData) {
                KonsumenResponse ret = new KonsumenResponse();
                ret.setId(data.getId());
                ret.setNama(data.getNama());
                ret.setAlamat(data.getAlamat());
                ret.setKota(data.getKota());
                ret.setProvinsi(data.getProvinsi());
                ret.setTglRegistrasi(df.format(data.getTglRegistrasi()));
                String status = data.getStatus().equalsIgnoreCase("1") ? "Aktif" : "Non-Aktif";
                ret.setStatus(status);
                listData.add(ret);
            }
            return listData;
        } catch (Exception e) {
            return listData;
        }
    }

    public Konsumen addKonsumen(Konsumen dto) {
        dto.setTglRegistrasi(new Date());
        konsumenRepo.save(dto);
        konsumenRepo.flush();
        return dto;
    }

    public List<Konsumen> getAll() {
        return konsumenRepo.findAll();
    }
}

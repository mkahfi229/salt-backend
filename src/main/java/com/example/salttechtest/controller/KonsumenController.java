package com.example.salttechtest.controller;

import com.example.salttechtest.dto.Konsumen;
import com.example.salttechtest.dto.KonsumenRequest;
import com.example.salttechtest.dto.KonsumenResponse;
import com.example.salttechtest.repository.IKonsumenRepo;
import com.example.salttechtest.service.KonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/konsumen")
public class KonsumenController {

    @Autowired
    @Qualifier("konsumenService")
    private KonsumenService konsumenService;

    public KonsumenController() {

    }

    @PostMapping("/test")
    public String runApp() {
        return "Apps Now Running !!";
    }

    @PostMapping("/add")
    public ResponseEntity<Konsumen> addKonsumen(@RequestBody Konsumen dto) {
        try {
            Konsumen res = konsumenService.addKonsumen(dto);
            return new ResponseEntity<Konsumen>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getall")
    public ResponseEntity<List<Konsumen>> getKonsumen() {
        try {
            List<Konsumen> data = konsumenService.getAll();
            return new ResponseEntity<List<Konsumen>>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<KonsumenResponse>> getSearch(@RequestBody KonsumenRequest req) {
        try {
            List<KonsumenResponse> ret = konsumenService.getMonitorData(req);
            return new ResponseEntity<List<KonsumenResponse>>(ret, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.salttechtest.repository;

import com.example.salttechtest.dto.Konsumen;
import com.example.salttechtest.dto.KonsumenRequest;
import com.example.salttechtest.dto.KonsumenResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("konsumenRepo")
public interface IKonsumenRepo extends JpaRepository<Konsumen, Integer> {

    @Query(value = "SELECT A.* FROM konsumen A where A.id = ?1", nativeQuery = true)
    public List<Konsumen> getUserById(Integer id);
}

package com.example.lab4emt.repository;

import com.example.lab4emt.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByTitle(String title);
    List<Record> findByArtist(String artist);
    List<Record> findByCondition(String condition);

}
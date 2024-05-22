package com.example.lab4emt.service;

import com.example.lab4emt.model.Record;

import java.util.List;
import java.util.Optional;

public interface RecordService {
    List<Record> findAll();
    Record save(Record record);
    Optional<Record> findById(Long id);
    void deleteById(Long id);
    Record update(Long id, Record updatedRecord);

    List<Record> findByTitle(String title);
    List<Record> findByArtist(String artist);
    List<Record> findByCondition(String condition);
}
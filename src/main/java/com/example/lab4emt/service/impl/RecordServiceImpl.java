package com.example.lab4emt.service.impl;

import com.example.lab4emt.model.Record;
import com.example.lab4emt.repository.RecordRepository;
import com.example.lab4emt.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public Optional<Record> findById(Long id) {
        return recordRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        recordRepository.deleteById(id);
    }

    @Override
    public Record update(Long id, Record updatedRecord) {
        return recordRepository.findById(id)
                .map(record -> {
                    record.setTitle(updatedRecord.getTitle());
                    record.setArtist(updatedRecord.getArtist());
                    record.setPrice(updatedRecord.getPrice());
                    record.setCondition(updatedRecord.getCondition());
                    return recordRepository.save(record);
                })
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));
    }

    @Override
    public List<Record> findByTitle(String title) {
        return recordRepository.findByTitle(title);
    }

    @Override
    public List<Record> findByArtist(String artist) {
        return recordRepository.findByArtist(artist);
    }

    @Override
    public List<Record> findByCondition(String condition) {
        return recordRepository.findByCondition(condition);
    }
}
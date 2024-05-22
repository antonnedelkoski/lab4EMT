package com.example.lab4emt.web;

import com.example.lab4emt.model.Record;
import com.example.lab4emt.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping
    public List<Record> getAllRecords() {
        return recordService.findAll();
    }

    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        return recordService.save(record);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Long id) {
        Optional<Record> record = recordService.findById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Long id, @RequestBody Record recordDetails) {
        try {
            Record updatedRecord = recordService.update(id, recordDetails);
            return ResponseEntity.ok(updatedRecord);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Record> searchRecords(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String condition) {
        if (title != null) {
            return recordService.findByTitle(title);
        } else if (artist != null) {
            return recordService.findByArtist(artist);
        } else if (condition != null) {
            return recordService.findByCondition(condition);
        } else {
            return recordService.findAll();
        }
    }
}

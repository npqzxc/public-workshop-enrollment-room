package com.example.app.service;

import com.example.app.model.RecordItem;
import com.example.app.repository.RecordRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    private final RecordRepository repository;

    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }

    public List<RecordItem> list() {
        return repository.findAll();
    }

    public Optional<RecordItem> find(String id) {
        return repository.findById(id);
    }

    public RecordItem create(String title, String owner, String note) {
        return repository.save(title, owner, note);
    }
}

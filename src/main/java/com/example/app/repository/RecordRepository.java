package com.example.app.repository;

import com.example.app.model.RecordItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepository {
    private final List<RecordItem> records = new ArrayList<>(List.of(
        new RecordItem("r1", "Workshop Enrollment Room 首轮安排", "mila", "进行中", "高", "关注关键节点和推进节奏。"),
        new RecordItem("r2", "Workshop Enrollment Room 协调会", "luna", "待处理", "中", "整理问题和后续动作。")
    ));

    public List<RecordItem> findAll() {
        return records;
    }

    public Optional<RecordItem> findById(String id) {
        return records.stream().filter(item -> item.id().equals(id)).findFirst();
    }

    public RecordItem save(String title, String owner, String note) {
        RecordItem item = new RecordItem("r" + (records.size() + 1), title, owner, "新建", "中", note);
        records.add(0, item);
        return item;
    }
}

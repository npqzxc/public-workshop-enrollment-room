package com.example.app.service;

import com.example.app.model.RecordItem;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final RecordService recordService;

    public DashboardService(RecordService recordService) {
        this.recordService = recordService;
    }

    public Map<String, Object> summary() {
        List<RecordItem> records = recordService.list();
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("total", records.size());
        payload.put("active", records.stream().filter(item -> "进行中".equals(item.status())).count());
        payload.put("highPriority", records.stream().filter(item -> "高".equals(item.priority())).count());
        payload.put("records", records);
        return payload;
    }
}

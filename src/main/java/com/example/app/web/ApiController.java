package com.example.app.web;

import com.example.app.model.RecordItem;
import com.example.app.service.DashboardService;
import com.example.app.service.RecordService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final DashboardService dashboardService;
    private final RecordService recordService;

    public ApiController(DashboardService dashboardService, RecordService recordService) {
        this.dashboardService = dashboardService;
        this.recordService = recordService;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        return dashboardService.summary();
    }

    @GetMapping("/records")
    public java.util.List<RecordItem> records() {
        return recordService.list();
    }

    @GetMapping("/records/{id}")
    public RecordItem detail(@PathVariable String id) {
        return recordService.find(id).orElseThrow();
    }

    @PostMapping("/records")
    public RecordItem create(@RequestBody Map<String, String> payload) {
        return recordService.create(payload.get("title"), payload.get("owner"), payload.get("note"));
    }
}

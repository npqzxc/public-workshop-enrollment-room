package com.example.app.web;

import com.example.app.service.DashboardService;
import com.example.app.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
    private final DashboardService dashboardService;
    private final RecordService recordService;

    public WebController(DashboardService dashboardService, RecordService recordService) {
        this.dashboardService = dashboardService;
        this.recordService = recordService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("title", "Workshop Enrollment Room");
        model.addAttribute("payload", dashboardService.summary());
        return "dashboard";
    }

    @GetMapping("/records")
    public String records(Model model) {
        model.addAttribute("title", "Workshop Enrollment Room");
        model.addAttribute("records", recordService.list());
        return "records";
    }

    @GetMapping("/records/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("title", "Workshop Enrollment Room");
        model.addAttribute("item", recordService.find(id).orElse(null));
        return "detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Workshop Enrollment Room");
        return "create";
    }
}

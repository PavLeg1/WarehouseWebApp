package com.warehouse.warehouse.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController { // Вывод статистики только для учетки админа

    @GetMapping("/statistics")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showStatistics() {
        return "statistics";
    }
}

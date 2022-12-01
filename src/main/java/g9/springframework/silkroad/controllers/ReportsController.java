package g9.springframework.silkroad.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.repositories.CustomerRepository;
import g9.springframework.silkroad.repositories.OrderRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/reports")
@AllArgsConstructor
public class ReportsController {
  private final CustomerRepository customerRepository;
  private final OrderRepository orderRepository;

  @GetMapping
  ResponseEntity<?> getReports() {
    LocalDateTime dateTimeOneMonthAgo = LocalDateTime.now().minusMonths(1);

    Map<String, Object> response = new HashMap<>();
    Integer newCustomers = customerRepository.countByCreatedAtAfter(dateTimeOneMonthAgo);
    Long totalRegisteredCustomers = customerRepository.count();
    Double totalRevenue = orderRepository.getTotalRevenue();
    Integer totalProductsSoldInLastMonth = orderRepository.getTotalProductsSold(dateTimeOneMonthAgo);
    response.put("newCustomers", newCustomers);
    response.put("totalRegisteredCustomers", totalRegisteredCustomers);
    response.put("totalRevenue", totalRevenue);
    response.put("totalProductsSoldInLastMonth", totalProductsSoldInLastMonth);
    return ResponseEntity.ok().body(response);
  }
}

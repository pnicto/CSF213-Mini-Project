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
    LocalDateTime dateTimeNow = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0);

    Map<String, Object> response = new HashMap<>();
    Map<String, Object> newlyRegisteredCustomersLastSixMonths = new HashMap<>();
    Map<String, Object> totalProductsSoldLastSixMonths = new HashMap<>();
    Map<String, Object> totalRevenueLastSixMonths = new HashMap<>();

    for (int i = 0; i < 7; i++) {
      var dateTime = dateTimeNow.minusMonths(i);
      var dateTimeMinusOne = dateTimeNow.minusMonths(i + 1);

      Integer newCustomersLastMonth = customerRepository.countByCreatedAtBetween(dateTimeMinusOne, dateTime);
      Integer totalProductsSoldLastMonth = orderRepository.getTotalProductsSoldBetween(dateTimeMinusOne, dateTime);
      Double totalRevenueLastMonth = orderRepository.getTotalRevenueBetween(dateTimeMinusOne, dateTime);

      newlyRegisteredCustomersLastSixMonths.put(dateTimeMinusOne.getMonth().toString(),
          newCustomersLastMonth);
      totalProductsSoldLastSixMonths.put(dateTimeMinusOne.getMonth().toString(),
          totalProductsSoldLastMonth);
      totalRevenueLastSixMonths.put(dateTimeMinusOne.getMonth().toString(), totalRevenueLastMonth);
    }

    var productsSoldThisMonth = orderRepository.getTotalProductsSoldBetween(dateTimeNow, LocalDateTime.now());
    totalProductsSoldLastSixMonths.put("now", productsSoldThisMonth);

    var newCustomersThisMonth = customerRepository.countByCreatedAtBetween(dateTimeNow, LocalDateTime.now());
    newlyRegisteredCustomersLastSixMonths.put("now", newCustomersThisMonth);

    var totalRevenueThisMonth = orderRepository.getTotalRevenueBetween(dateTimeNow, LocalDateTime.now());
    totalRevenueLastSixMonths.put("now", totalRevenueThisMonth);

    Long totalRegisteredCustomers = customerRepository.count();
    Double totalRevenue = orderRepository.getTotalRevenue();
    Integer totalProductsSold = orderRepository.getTotalProductsSold();

    response.put("newlyRegisteredCustomersLastSixMonths", newlyRegisteredCustomersLastSixMonths);
    response.put("totalRegisteredCustomers", totalRegisteredCustomers);
    response.put("totalRevenue", totalRevenue);
    response.put("totalRevenueLastSixMonths", totalRevenueLastSixMonths);
    response.put("totalProductsSold", totalProductsSold);
    response.put("totalProductsSoldLastSixMonths", totalProductsSoldLastSixMonths);

    return ResponseEntity.ok().body(response);
  }

}

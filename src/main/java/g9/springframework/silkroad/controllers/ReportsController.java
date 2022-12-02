package g9.springframework.silkroad.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    List<Object> newlyRegisteredCustomersLastSixMonths = new ArrayList<>();
    List<Object> totalProductsSoldLastSixMonths = new ArrayList<>();
    List<Object> totalRevenueLastSixMonths = new ArrayList<>();

    for (int i = 6; i >= 0; i--) {
      var dateTime = dateTimeNow.minusMonths(i);
      var dateTimeMinusOne = dateTimeNow.minusMonths(i + 1);

      Map<String, Object> newRegisteredMap = new HashMap<>();
      Map<String, Object> productsSoldMap = new HashMap<>();
      Map<String, Object> revenueMap = new HashMap<>();

      Integer newCustomersLastMonth = customerRepository.countByCreatedAtBetween(dateTimeMinusOne, dateTime);
      Integer totalProductsSoldLastMonth = orderRepository.getTotalProductsSoldBetween(dateTimeMinusOne, dateTime);
      Double totalRevenueLastMonth = orderRepository.getTotalRevenueBetween(dateTimeMinusOne, dateTime);

      newRegisteredMap.put("label", dateTimeMinusOne.getMonth().toString());
      newRegisteredMap.put("value", newCustomersLastMonth);
      newlyRegisteredCustomersLastSixMonths.add(newRegisteredMap);

      productsSoldMap.put("label", dateTimeMinusOne.getMonth().toString());
      productsSoldMap.put("value", totalProductsSoldLastMonth);
      totalProductsSoldLastSixMonths.add(productsSoldMap);

      revenueMap.put("label", dateTimeMinusOne.getMonth().toString());
      revenueMap.put("value", totalRevenueLastMonth);
      totalRevenueLastSixMonths.add(revenueMap);
    }

    Map<String, Object> newRegisteredMap = new HashMap<>();
    Map<String, Object> productsSoldMap = new HashMap<>();
    Map<String, Object> revenueMap = new HashMap<>();

    var newCustomersThisMonth = customerRepository.countByCreatedAtBetween(dateTimeNow, LocalDateTime.now());
    newRegisteredMap.put("label", dateTimeNow.getMonth().toString());
    newRegisteredMap.put("value", newCustomersThisMonth);
    newlyRegisteredCustomersLastSixMonths.add(newRegisteredMap);

    var productsSoldThisMonth = orderRepository.getTotalProductsSoldBetween(dateTimeNow, LocalDateTime.now());
    productsSoldMap.put("label", dateTimeNow.getMonth().toString());
    productsSoldMap.put("value", productsSoldThisMonth);
    totalProductsSoldLastSixMonths.add(productsSoldMap);

    var totalRevenueThisMonth = orderRepository.getTotalRevenueBetween(dateTimeNow, LocalDateTime.now());
    revenueMap.put("label", dateTimeNow.getMonth().toString());
    revenueMap.put("value", totalRevenueThisMonth);
    totalRevenueLastSixMonths.add(revenueMap);

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

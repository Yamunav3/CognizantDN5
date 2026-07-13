package com.cognizant.orm_learn.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.Model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    // Facebook stock details for September 2019 - fetch between dates
    static List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate) {
        return null;
    }

    // Google stock details where close price > 1250 - greater than
    static List<Stock> findByCodeAndCloseGreaterThan(String code, double close) {
        return null;
    }

    // Top 3 dates with highest volume of transactions
    static List<Stock> findTop3ByOrderByVolumeDesc() {
        return null;
    }

    // Netflix - 3 lowest close prices
    static List<Stock> findTop3ByCodeOrderByCloseAsc(String code) {
        return null;
    }


}
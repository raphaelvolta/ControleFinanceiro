package com.example.demo.service;

import com.example.demo.domain.Settlement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SettlementService {
    List<Settlement> getSettlements();
    Settlement getSettlement(Integer settlementId);
    Settlement postSettlement(Settlement settlement);
    Settlement putSettlement(Settlement settlement, Integer settlementId);
    void deleteSettlement(Integer settlementId);
}

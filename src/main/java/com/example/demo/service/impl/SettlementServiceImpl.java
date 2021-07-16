package com.example.demo.service.impl;

import com.example.demo.domain.Settlement;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.SettlementRepository;
import com.example.demo.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SettlementServiceImpl implements SettlementService {

    private final SettlementRepository settlementRepository;

    @Override
    public List<Settlement> getSettlements() {
        return settlementRepository.findAll();
    }

    @Override
    public Settlement getSettlement(Integer settlementId) {
        return settlementRepository.findById(settlementId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Settlement postSettlement(Settlement settlement) {
        return settlementRepository.save(settlement);
    }

    @Override
    public Settlement putSettlement(Settlement settlement, Integer settlementId) {
        settlementRepository.findById(settlementId).orElseThrow(EntityNotFoundException::new);
        settlement.setSettlementId(settlementId);
        return settlementRepository.save(settlement);
    }

    @Override
    public void deleteSettlement(Integer settlementId) {
        Settlement settlement = settlementRepository.findById(settlementId).orElseThrow(EntityNotFoundException::new);
        settlementRepository.delete(settlement);
    }
}

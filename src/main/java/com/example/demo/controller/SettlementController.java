package com.example.demo.controller;

import com.example.demo.domain.Settlement;
import com.example.demo.jsonDto.SettlementDto;
import com.example.demo.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/settlements")
@RequiredArgsConstructor
public class SettlementController {

    private final SettlementService settlementService;

    @GetMapping
    public ResponseEntity<List<Settlement>> getSettlements(){
        return ResponseEntity.ok(settlementService.getSettlements());
    }

    @GetMapping("/{settlementId}")
    public ResponseEntity<Settlement> getSettlementById(
            @PathVariable("settlementId") Integer settlementId){
        return ResponseEntity.ok(settlementService.getSettlement(settlementId));
    }

    @PostMapping
    public ResponseEntity<Settlement> postSettlement(
            @RequestBody SettlementDto settlementDto){
        return ResponseEntity.ok(settlementService.postSettlement(settlementDto.toDomain()));
    }

    @PutMapping("/{settlementId}")
    public ResponseEntity<Settlement> putSettlement(
        @PathVariable("settlementId") Integer settlementId,
        @RequestBody Settlement settlement){
        return ResponseEntity.ok(settlementService.putSettlement(settlement, settlementId));
    }

    @DeleteMapping("/{settlementId}")
    public ResponseEntity<Settlement> deleteSettlement(
            @PathVariable("settlementId") Integer settlementId){
        settlementService.deleteSettlement(settlementId);
        return ResponseEntity.noContent().build();
    }

}

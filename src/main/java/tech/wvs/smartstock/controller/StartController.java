package tech.wvs.smartstock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.wvs.smartstock.controller.dto.StartDto;
import tech.wvs.smartstock.service.SmartStockService;

import java.util.concurrent.CompletableFuture;

@RestController
public class StartController {

    private final SmartStockService smartStockService;

    public StartController(SmartStockService smartStockService) {
        this.smartStockService = smartStockService;
    }

    @PostMapping(path = "/start")
    public ResponseEntity<Void> start(@RequestBody StartDto data){

        CompletableFuture.runAsync(() -> {
            smartStockService.start(data.reportPath());
        });

        return ResponseEntity.accepted().build();
    }
}

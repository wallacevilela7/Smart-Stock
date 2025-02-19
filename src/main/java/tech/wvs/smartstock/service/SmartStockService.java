package tech.wvs.smartstock.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SmartStockService {

    private final ReportService reportService;

    public SmartStockService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void start(String reporPath){

        //TODO 1: ler o arquivo csv
        try {
            var items = reportService.readStockReport(reporPath);

        } catch (IOException e) {
            throw new RuntimeException();
        }

        //TODO 2: para cada item do csv chamar a api do setor de compras



        //TODO 3: salvar no mongodb os itens que foram recomprados
    }

}

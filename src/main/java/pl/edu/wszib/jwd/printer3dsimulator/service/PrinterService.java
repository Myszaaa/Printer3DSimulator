package pl.edu.wszib.jwd.printer3dsimulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.printer3dsimulator.model.Printer;
import pl.edu.wszib.jwd.printer3dsimulator.repository.PrinterRepository;

@Service
public class PrinterService {

    @Autowired
    private PrinterRepository printerRepository;

    public Printer findById(Long id) {
        return printerRepository.findById(id).orElse(null);
    }

    public void save(Printer printer) {
        printerRepository.save(printer);
    }

    public void startPrinting(Long id, int printingTimeInSeconds) {
        Printer printer = findById(id);
        if (printer != null) {
            printer.setPrintingTime((long) printingTimeInSeconds);
            printer.setStatus("In progress");
            save(printer);

            final int[] remainingTime = {printingTimeInSeconds};

            new Thread(() -> {
                try {
                    while (remainingTime[0] > 0) {
                        Thread.sleep(1000);
                        remainingTime[0]--;
                        printer.setPrintingTime((long) remainingTime[0]);
                        save(printer);
                    }
                    printer.setStatus("Completed");
                    printer.setPrintingTime(0L);
                    save(printer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
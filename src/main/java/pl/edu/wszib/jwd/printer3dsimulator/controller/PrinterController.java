package pl.edu.wszib.jwd.printer3dsimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.jwd.printer3dsimulator.service.PrinterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrinterController {


    @Autowired
    private PrinterService printerService;

    @GetMapping("/set_print_time")
    public String showSetPrintTimeForm(Model model) {
        return "set_print_time";
    }

    @PostMapping("/set_print_time")
    public String setPrintTime(@RequestParam Long id,
                               @RequestParam int printingTime,
                               Model model) {
        printerService.startPrinting(id, printingTime);
        model.addAttribute("message", "Printer " + id + " started printing for " + printingTime + " seconds.");
        return "set_print_time";
    }
}


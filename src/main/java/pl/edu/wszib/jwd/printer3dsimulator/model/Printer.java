package pl.edu.wszib.jwd.printer3dsimulator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Printers", schema = "printerUnits")
public class Printer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;
    private String location;

    private Long printingTime;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getPrintingTime() {
        return printingTime;
    }

    public void setPrintingTime(Long printingTime) {
        this.printingTime = printingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package pl.edu.wszib.jwd.printer3dsimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.printer3dsimulator.model.Printer;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Long> {
}
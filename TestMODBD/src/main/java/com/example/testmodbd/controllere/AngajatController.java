package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Angajat;
import com.example.testmodbd.repo.AngajatRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class AngajatController {
    AngajatRepo angajatRepo = new AngajatRepo();

    @GetMapping("/angajat")
    public List<Angajat> getAllAngajat() throws ClassNotFoundException{
        return angajatRepo.findAll();
    }

    @DeleteMapping("/angajat/{id}")
    public void deleteAngajat(@PathVariable("id") int id) throws ClassNotFoundException{
        angajatRepo.delete(id);
    }

    @PostMapping("/angajat")
    public void addAngajat(int id_angajat, String nume, String nr_telefon, String rol, int cnp, double salariu, String iban, int id_magazin_fk) throws ClassNotFoundException{
        Angajat angajat = new Angajat(id_angajat, nume, nr_telefon, rol, cnp, salariu, iban, id_magazin_fk);
        angajatRepo.insert(angajat);
    }

    @PutMapping("/angajat/{id}")
    public ResponseEntity<Void> updateAngajat(@PathVariable("id") int id, @RequestBody Angajat entity) throws ClassNotFoundException{
        Angajat angajat = angajatRepo.findById(id);
        if(angajat != null){
            angajat.setId_angajat(entity.getId_angajat());
            angajat.setNume(entity.getNume());
            angajat.setNr_telefon(entity.getNr_telefon());
            angajat.setRol(entity.getRol());
            angajat.setCnp(entity.getCnp());
            angajat.setSalariu(entity.getSalariu());
            angajat.setIban(entity.getIban());
            angajat.setId_magazin_fk(entity.getId_magazin_fk());
            angajatRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

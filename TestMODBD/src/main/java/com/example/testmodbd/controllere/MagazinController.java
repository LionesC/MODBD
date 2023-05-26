package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Magazin;
import com.example.testmodbd.repo.MagazinRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class MagazinController {
    MagazinRepo magazinRepo = new MagazinRepo();

    @GetMapping("/magazin")
    public List<Magazin> getAllMagazin() throws ClassNotFoundException{
        return magazinRepo.findAll();
    }

    @DeleteMapping("/magazin/{id}")
    public void deleteMagazin(@PathVariable("id") int id) throws ClassNotFoundException{
        magazinRepo.delete(id);
    }

    @PostMapping("/magazin")
    public void addMagazin(int id_magazin, String nume, int id_adresa_fk) throws ClassNotFoundException{
        Magazin magazin = new Magazin(id_magazin, nume, id_adresa_fk);
        magazinRepo.insert(magazin);
    }

    @PutMapping("/magazin/{id}")
    public ResponseEntity<Void> updateMagazin(@PathVariable("id") int id, @RequestBody Magazin entity) throws ClassNotFoundException{
        Magazin magazin = magazinRepo.findById(id);
        if(magazin != null){
            magazin.setId_magazin(entity.getId_magazin());
            magazin.setNume(entity.getNume());
            magazin.setId_adresa_fk(entity.getId_adresa_fk());

            magazinRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

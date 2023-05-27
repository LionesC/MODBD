package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Produs;
import com.example.testmodbd.repo.ProdusRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ProdusController {
    ProdusRepo produsRepo = new ProdusRepo();

    @GetMapping("/produs")
    public List<Produs> getAllProdus() throws ClassNotFoundException{
        return produsRepo.findAll();
    }

    @DeleteMapping("/produs/{id}")
    public void deleteProdus(@PathVariable("id") int id) throws ClassNotFoundException{
        produsRepo.delete(id);
    }

    @PostMapping("/produs")
    public void addProdus(int id_produs, String nume, double pret, String categorie) throws ClassNotFoundException{
        Produs produs = new Produs(id_produs, nume, pret, categorie);
        produsRepo.insert(produs);
    }

    @PutMapping("/produs/{id}")
    public ResponseEntity<Void> updateProdus(@PathVariable("id") int id, @RequestBody Produs entity) throws ClassNotFoundException{
        Produs produs = produsRepo.findById(id);
        if(produs != null){
            produs.setId_produs(entity.getId_produs());
            produs.setNume(entity.getNume());
            produs.setPret(entity.getPret());
            produs.setCategorie(entity.getCategorie());

            produsRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Livrare;
import com.example.testmodbd.repo.LivrareRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class LivrareController {
    LivrareRepo livrareRepo = new LivrareRepo();

    @GetMapping("/livrare")
    public List<Livrare> getAllLivrare() throws ClassNotFoundException{
        return livrareRepo.findAll();
    }

    @DeleteMapping("/livrare/{id}")
    public void deleteLivrare(@PathVariable("id") int id) throws ClassNotFoundException{
        livrareRepo.delete(id);
    }

    @PostMapping("/livrare")
    public void addLivrare(int id_livrare, double pret, int id_client_fk, int id_angajat_fk, int id_adresa_fk) throws ClassNotFoundException{
        Livrare livrare = new Livrare(id_livrare, pret, id_client_fk, id_angajat_fk, id_adresa_fk);
        livrareRepo.insert(livrare);
    }

    @PutMapping("/livrare/{id}")
    public ResponseEntity<Void> updateLivrare(@PathVariable("id") int id, @RequestBody Livrare entity) throws ClassNotFoundException{
        Livrare livrare = livrareRepo.findById(id);
        if(livrare != null){
            livrare.setId_livrare(entity.getId_livrare());
            livrare.setPret(entity.getPret());
            livrare.setId_client_fk(entity.getId_client_fk());
            livrare.setId_angajat_fk(entity.getId_angajat_fk());
            livrare.setId_adresa_fk(entity.getId_adresa_fk());

            livrareRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Comanda;
import com.example.testmodbd.repo.ComandaRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ComandaController {
    ComandaRepo comandaRepo = new ComandaRepo();

    @GetMapping("/comanda")
    public List<Comanda> getAllComanda() throws ClassNotFoundException{
        return comandaRepo.findAll();
    }

    @DeleteMapping("/comanda/{id}")
    public void deleteComanda(@PathVariable("id") int id) throws ClassNotFoundException{
        comandaRepo.delete(id);
    }

    @PostMapping("comanda")
    public void addComanda(int id_comanda, double pret, String detalii, int id_livrare, int id_angajat, int id_client) throws ClassNotFoundException{
        Comanda comanda = new Comanda(id_comanda, pret, detalii, id_livrare, id_angajat, id_client);
        comandaRepo.insert(comanda);
    }

    @PutMapping("/comanda/{id}")
    public ResponseEntity<Void> updateComanda(@PathVariable("id") int id, @RequestBody Comanda entity) throws ClassNotFoundException{
        Comanda comanda = comandaRepo.findById(id);
        if(comanda != null){
            comanda.setId_comanda(entity.getId_comanda());
            comanda.setPret(entity.getPret());
            comanda.setDetalii(entity.getDetalii());

            comandaRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

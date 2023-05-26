package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Oras;
import com.example.testmodbd.repo.OrasRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class OrasController {
    OrasRepo orasRepo = new OrasRepo();

    @GetMapping("/oras")
    public List<Oras> getAllOras() throws ClassNotFoundException{
        return orasRepo.findAll();
    }

    @DeleteMapping("/oras/{id}")
    public void deleteOras(@PathVariable("id") int id) throws ClassNotFoundException{
        orasRepo.delete(id);
    }

    @PostMapping("/oras")
    public void addOras(int id_oras, String nume) throws ClassNotFoundException{
        Oras oras = new Oras(id_oras, nume);
        orasRepo.insert(oras);
    }

    @PutMapping("/oras/{id}")
    public ResponseEntity<Void> updateOras(@PathVariable("id") int id, @RequestBody Oras entity) throws ClassNotFoundException {
        Oras oras = orasRepo.findById(id);
        if(oras != null){
            oras.setId_oras(entity.getId_oras());
            oras.setNume(entity.getNume());
            orasRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

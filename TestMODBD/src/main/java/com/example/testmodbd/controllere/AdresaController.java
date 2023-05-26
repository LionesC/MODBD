package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Adresa;
import com.example.testmodbd.repo.AdresaRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AdresaController {
    AdresaRepo adresaRepo = new AdresaRepo();

    @GetMapping("/adresa")
    public List<Adresa> getAllAdresa() throws ClassNotFoundException{
        return adresaRepo.findAll();
    }

    @DeleteMapping("/adresa/{id}")
    public void deleteAdresa(@PathVariable("id") int id) throws ClassNotFoundException{
        adresaRepo.delete(id);
    }

    @PostMapping("/adresa")
    public void addAdresa(int id_adresa, String cod_postal, String strada, int sector, String detalii, int id_oras_fk) throws ClassNotFoundException{
        Adresa adresa = new Adresa(id_adresa, cod_postal, strada, sector, detalii, id_oras_fk);
        adresaRepo.insert(adresa);
    }

    @PutMapping("/adresa/{id}")
    public ResponseEntity<Void> updateAdresa(@PathVariable("id") int id, @RequestBody Adresa entity) throws ClassNotFoundException{
        Adresa adresa = adresaRepo.findById(id);

        if (adresa != null){
            adresa.setId_adresa(entity.getId_adresa());
            adresa.setCod_postal(entity.getCod_postal());
            adresa.setStrada(entity.getStrada());
            adresa.setSector(entity.getSector());
            adresa.setDetalii(entity.getDetalii());
            adresa.setId_oras_fk(entity.getId_oras_fk());

            adresaRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

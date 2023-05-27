package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Bautura;
import com.example.testmodbd.repo.BauturaRepo;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class BauturaController {
    BauturaRepo bauturaRepo = new BauturaRepo();

    @GetMapping("/bautura")
    public List<Bautura> getAllBautura() throws ClassNotFoundException{
        return bauturaRepo.findAll();
    }

    @DeleteMapping("/bautura/{id}")
    public void deleteBautura(@PathVariable("id") int id) throws ClassNotFoundException{
        bauturaRepo.delete(id);
    }

    @PostMapping("/bautura")
    public void addBautura(int id_bautura, String alcoolic) throws ClassNotFoundException{
        Bautura bautura = new Bautura(id_bautura, alcoolic);
        bauturaRepo.insert(bautura);
    }

    @PutMapping("/bautura/{id}")
    public ResponseEntity<Void> updateBautura(@PathVariable("id") int id, @RequestBody Bautura entity) throws ClassNotFoundException{
        Bautura bautura = bauturaRepo.findById(id);
        if(bautura != null){
            bautura.setId_bautura(entity.getId_bautura());
            bautura.setAlcoolic(entity.getAlcoolic());

            bauturaRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }
}

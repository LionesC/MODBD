package com.example.testmodbd.controllere;

import com.example.testmodbd.model.ProdusComanda;
import com.example.testmodbd.repo.ProdusComandaRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ProdusComandaController {
    ProdusComandaRepo produsComandaRepo = new ProdusComandaRepo();

    @GetMapping("/produscomanda")
    public List<ProdusComanda> getAllProdusComanda() throws ClassNotFoundException{
        return produsComandaRepo.findAll();
    }

    @DeleteMapping("/produscomanda/{idp}{idc}")
    public void deleteProdusComadna(@PathVariable("idp") int idp, @PathVariable("idc") int idc) throws ClassNotFoundException{
        produsComandaRepo.delete(idc, idp);
    }

    @PostMapping("/produscomanda")
    public void addProdusComanda(int id_produs, int id_comanda, double pret, int cantitate) throws ClassNotFoundException{
        ProdusComanda produsComanda = new ProdusComanda(id_produs, id_comanda, pret, cantitate);
        produsComandaRepo.update(produsComanda);
    }

    @PutMapping("/produscomanda/{idp}{idc}")
    public ResponseEntity<Void> updateProdusComanda(@PathVariable("idp") int idp, @PathVariable("idc") int idc, @RequestBody ProdusComanda entity) throws ClassNotFoundException{
        ProdusComanda produsComanda = produsComandaRepo.findById(idp, idc);
        if (produsComanda != null){
            produsComanda.setId_produs(entity.getId_produs());
            produsComanda.setId_comanda(entity.getId_comanda());
            produsComanda.setPret(entity.getPret());
            produsComanda.setCantitate(entity.getCantitate());

            produsComandaRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }
}

package com.example.testmodbd.controllere;

import com.example.testmodbd.model.Client;
import com.example.testmodbd.repo.ClientRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ClientController {
    ClientRepo clientRepo = new ClientRepo();

    @GetMapping("/client")
    public List<Client> getAllClient() throws ClassNotFoundException{
        return clientRepo.findAll();
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") int id) throws ClassNotFoundException{
        clientRepo.delete(id);
    }

    @PostMapping("/client")
    public void addClient(int id_client, String nume, String prenume, String email, String nr_telefon) throws ClassNotFoundException{
        Client client = new Client(id_client, nume, prenume, email, nr_telefon);
        clientRepo.insert(client);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable("id") int id, @RequestBody Client entity) throws ClassNotFoundException{
        Client client = clientRepo.findById(id);
        if(client != null){
            client.setId_client(entity.getId_client());
            client.setNume(entity.getNume());
            client.setPrenume(entity.getPrenume());
            client.setEmail(entity.getEmail());
            client.setNr_telefon(entity.getNr_telefon());

            clientRepo.update(entity);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

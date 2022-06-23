package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.model.Shipper;
import pe.edu.pe.bytebackend.service.ShipperService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @GetMapping
    public List<Shipper> listShippers(){
        return shipperService.listShipper();
    }

    @GetMapping("{id}")
    public Optional<Shipper> shipperById(@PathVariable Integer id){
        return shipperService.shipperById(id);
    }

    @PostMapping()
    public Shipper saveShipper(@RequestBody Shipper shipper){

        return shipperService.saveShipper(shipper);
    }

    @PutMapping("{id}")
    public void deleteShipper(@PathVariable Integer id){
        this.shipperService.deleteShipper(id);
    }
}

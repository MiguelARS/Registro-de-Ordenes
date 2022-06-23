package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.model.Shipper;
import pe.edu.pe.bytebackend.repository.ShipperRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;

    public List<Shipper> listShipper(){
        return shipperRepository.findAll();
    }

    public Optional<Shipper> shipperById(Integer id){
        return shipperRepository.findById(id);
    }

    public Shipper saveShipper(Shipper shipper){
        return shipperRepository.save(shipper);
    }

    public void deleteShipper(Integer id){
        shipperRepository.deleteById(id);
    }
}

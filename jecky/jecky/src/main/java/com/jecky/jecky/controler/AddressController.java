package com.jecky.jecky.controler;

import com.jecky.jecky.model.Address;
import com.jecky.jecky.repository.AddressRepository;
import com.jecky.jecky.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/address")
public class AddressController {
    @Autowired
    AddressService service;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllAddress(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                       @RequestParam(value = "sortKey", defaultValue = "name") String sortKey) {
        return service.getAllAddress(pageNo, sortKey);
    }

    @DeleteMapping("/delete")

    Map<String, Object> deleteById(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (service.deleteByAddressId(id)) {
            result.put("success", true);
        } else {
            result.put("success", false);

        }
        return result;
    }

    @PutMapping("/update")
    Map<String, Object> UpdateAddress(@RequestBody Address body) {
        Map<String, Object> result = new HashMap<>();
        if (service.updateAddress(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }

    @PostMapping("/insert")
    public boolean insertAddress(@RequestBody Address address) {
        return service.updateAddress(address);
    }


}

package com.practice.store.controller;

import com.practice.store.entity.BuyerEntity;
import com.practice.store.service.implimentations.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyers")
    public List<BuyerEntity> getAllBuyers() {
        return buyerService.getAll();
    }

    @GetMapping("/buyers/{buyerId:\\d+}")
    public BuyerEntity getBuyerById(@PathVariable("buyerId") int id) {
        return buyerService.getById(id);
    }

    @PostMapping("/buyers")
    @ResponseStatus(HttpStatus.CREATED)
    public BuyerEntity createBuyer(@RequestBody BuyerEntity request) {
        return buyerService.create(request);
    }

    @PutMapping("/buyers/{buyerId}")
    public BuyerEntity updateBuyer(@PathVariable("buyerId") int id, @RequestBody BuyerEntity request) {
        return buyerService.update(id, request);
    }

    @DeleteMapping("/buyers/{buyerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBuyer(@PathVariable("buyerId") int id) {
        buyerService.delete(id);
    }
}

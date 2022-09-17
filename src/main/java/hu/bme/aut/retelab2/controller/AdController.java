package hu.bme.aut.retelab2.controller;

import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.domain.Note;
import hu.bme.aut.retelab2.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class AdController {

    @Autowired
    private AdRepository adRepository;

    @PostMapping
    public Ad create(@RequestBody Ad ad) {
        ad.setId(null);
        return adRepository.save(ad);
    }

    @GetMapping
    public List<Ad> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer minimumValue,
            @RequestParam(required = false, defaultValue = "10 000 000") Integer maximumValue)
    {
        return adRepository.findByPriceRange(minimumValue, maximumValue);
    }
}

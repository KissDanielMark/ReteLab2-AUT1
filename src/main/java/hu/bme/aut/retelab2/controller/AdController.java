package hu.bme.aut.retelab2.controller;

import hu.bme.aut.retelab2.SecretGenerator;
import hu.bme.aut.retelab2.domain.Ad;
import hu.bme.aut.retelab2.domain.Note;
import hu.bme.aut.retelab2.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        ad.setCode(SecretGenerator.generate());
        return adRepository.save(ad);
    }

    @GetMapping
    public List<Ad> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer minimumValue,
            @RequestParam(required = false, defaultValue = "10 000 000") Integer maximumValue)
    {
        List<Ad> eredmeny =  adRepository.findByPriceRange(minimumValue, maximumValue);
        for(int i = 0;i<eredmeny.size();i++)
        {
            eredmeny.get(i).setCode(null);
        }
        return eredmeny;
    }

    @PutMapping
    public ResponseEntity<Ad> update(@RequestBody Ad ad) {
        Ad a = adRepository.find(ad);
        if (a == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        a = adRepository.save(ad);
        return ResponseEntity.ok(a);
    }
}

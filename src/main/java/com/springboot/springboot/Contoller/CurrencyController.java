package com.springboot.springboot.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/Currency")
@CrossOrigin(origins = "https://cheap-games-frontend.vercel.app")
public class CurrencyController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<String> getCurrency() {
        try {
            String url = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_8bdfHMxoCKJI5PzTf82uaW6QCpqs7zP0wlhnCTjr";
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch from freecurrencyapi");
        }
    }
}

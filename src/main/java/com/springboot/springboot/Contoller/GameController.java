package com.springboot.springboot.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "https://cheap-games-frontend.vercel.app")
public class GameController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<String> getGames(@RequestParam String title) {
        try {
            String url = "https://www.cheapshark.com/api/1.0/games?title=" + title;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch from CheapShark");
        }
    }
}

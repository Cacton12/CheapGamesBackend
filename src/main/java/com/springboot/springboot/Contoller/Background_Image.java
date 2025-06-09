package com.springboot.springboot.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/Background_Image")
@CrossOrigin(origins = "https://cheap-games-frontend.vercel.app")
public class Background_Image {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<String> getBackground_Image(@RequestParam String title) {
        try {
            String url = "https://api.rawg.io/api/games?key=df2d13f5c784406788b55315b2168212&search=" + title;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch from rawg.io");
        }
    }
}

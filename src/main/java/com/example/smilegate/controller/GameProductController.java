package com.example.smilegate.controller;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.GameRequest;
import com.example.smilegate.services.GameProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tai Nguyen
 */
@RestController
@RequestMapping("/game")
public class GameProductController {
    @Autowired
    private GameProductService gameProductService;

    @GetMapping("/listGame")
    public List<GameProduct> getListGame() {
        List<GameProduct> test = gameProductService.getListGame();
        return test;
    }

    @GetMapping("/game/{id}")
    public GameProduct getListGame(@PathVariable Long id) {
        GameProduct test = gameProductService.getListGame().get(0);
        return test;
    }

    @PostMapping("/create")
    public void createGame(@RequestBody GameRequest request){
        gameProductService.createGame(request);
    }


}

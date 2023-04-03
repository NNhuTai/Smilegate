package com.example.smilegate.controller;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.GameRequest;
import com.example.smilegate.services.IGameProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tai Nguyen
 */
@RestController
@AllArgsConstructor
@RequestMapping("/game")
public class GameProductController {

    private final IGameProductService gameProductService;

    @GetMapping("/listGame")
    public List<GameProduct> getListGame() {
        return gameProductService.getListGame();
    }

    @GetMapping("/game/{id}")
    public GameProduct getListGame(@PathVariable Long id) {
        return gameProductService.getListGame().get(0);
    }

    @PostMapping("/create")
    public void createGame(@RequestBody GameRequest request){
        gameProductService.createGame(request);
    }


}

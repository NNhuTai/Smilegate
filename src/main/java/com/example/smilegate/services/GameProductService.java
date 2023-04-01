package com.example.smilegate.services;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.GameRequest;
import com.example.smilegate.repos.GameProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tai Nguyen
 */
@Service
public class GameProductService {
    @Autowired
    private GameProductRepo gameProductRepo;

    public List<GameProduct> getListGame(){
        return gameProductRepo.findAll();
    }

    public void createGame(GameRequest request) {
        GameProduct gameProduct = new GameProduct();

        gameProduct.setCategoryId(request.getCategoryId());
        gameProduct.setName(request.getName());
        gameProduct.setPrice(request.getPrice());

        gameProductRepo.save(gameProduct);
    }
}

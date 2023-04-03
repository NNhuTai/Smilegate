package com.example.smilegate.services;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.GameRequest;
import com.example.smilegate.repos.GameProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tai Nguyen
 */
@Service
@AllArgsConstructor
public class GameProductService implements IGameProductService {
    private final GameProductRepo gameProductRepo;

    @Override
    public List<GameProduct> getListGame(){
        return gameProductRepo.findAll();
    }

    @Override
    public void createGame(GameRequest request) {
        GameProduct gameProduct = new GameProduct();

        gameProduct.setCategoryId(request.getCategoryId());
        gameProduct.setName(request.getName());
        gameProduct.setPrice(request.getPrice());

        gameProductRepo.save(gameProduct);
    }
}

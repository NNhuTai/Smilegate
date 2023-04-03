package com.example.smilegate.services;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.GameRequest;

import java.util.List;

/**
 * @author Tai Nguyen
 */
public interface IGameProductService {
    List<GameProduct> getListGame();
    void createGame(GameRequest request);
}

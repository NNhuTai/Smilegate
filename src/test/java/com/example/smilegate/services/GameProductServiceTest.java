package com.example.smilegate.services;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.repos.GameProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Tai Nguyen
 */
public class GameProductServiceTest {
    private GameProductService gameProductService;

    @BeforeEach
    void setMockOutput() {
        GameProductRepo gameProductRepo = Mockito.mock(GameProductRepo.class);
        gameProductService = new GameProductService(gameProductRepo);
        List<GameProduct> list = new ArrayList<>();
        list.add(new GameProduct());
        when(gameProductRepo.findAll()).thenReturn(list);
    }
    @Test
    void checkGameName(){
        assertEquals(1, gameProductService.getListGame().size());
    }
}

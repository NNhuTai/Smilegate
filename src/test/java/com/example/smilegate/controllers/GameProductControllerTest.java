package com.example.smilegate.controllers;

import com.example.smilegate.controller.GameProductController;
import com.example.smilegate.model.GameProduct;
import com.example.smilegate.services.GameProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Tai Nguyen
 */
@ExtendWith(MockitoExtension.class)
public class GameProductControllerTest {
    @Mock
    private GameProductService gameProductService;
    @InjectMocks
    private GameProductController gameProductController;
    @BeforeEach
    void setMockOutput()
    {
        List<GameProduct> list = Arrays.asList(new GameProduct(), new GameProduct());
        when(gameProductService.getListGame()).thenReturn(list);
    }
    @Test
    void testListGame()
    {
        assertEquals(2, gameProductController.getListGame().size());
    }
}

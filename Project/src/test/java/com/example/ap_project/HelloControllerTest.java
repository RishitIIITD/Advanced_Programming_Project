package com.example.ap_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HelloControllerTest {
    @Test
    void add(){
        int a=5;
        int b=10;
        int sum=HelloController.add(a,b);
        assertEquals(sum, 15, "Failed Test");
    }

    @Test
    void onHelloButtonClick() {

    }

    @Test
    void pressing() {
    }

    @Test
    void released() {
    }

    @Test
    void pause() {
    }

    @Test
    void fade() {
    }

    @Test
    void initialize() {
    }
}
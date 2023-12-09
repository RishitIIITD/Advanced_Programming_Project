package com.example.ap_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StickTest {

    @Test
    void getStick() {
    }

    @Test
    void increaseHeight() {
    }

    @Test
    void rotate90degrees() {
    }

    @Test
    void did_land() {
        double min=5;
        double max=35;
        double mid=20;

        boolean land;

        if (min<=mid && mid<=max){
            land=true;
        }
        else{
            land=false;
        }
        assertEquals(land, true, "Failed");
    }

    @Test
    void removeStick() {
    }
}
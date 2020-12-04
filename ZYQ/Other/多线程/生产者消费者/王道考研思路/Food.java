package com.zyq.concurrent_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Food {
    private static Integer food=0;
    public Food() { }
    public static Integer getFood() {
        return food;
    }

    public static void setFood(Integer food) {
        Food.food = food;
    }
    public void comsumeFood(){
        food-=1;
    }
    public void produceFood(){
        food+=1;
    }
}

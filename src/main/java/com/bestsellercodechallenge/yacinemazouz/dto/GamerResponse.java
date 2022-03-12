package com.bestsellercodechallenge.yacinemazouz.dto;

import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import com.bestsellercodechallenge.yacinemazouz.entity.Interest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GamerResponse {
    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    private Gamer gamer;
    private ArrayList<Interest> interests = new ArrayList<Interest>();
}

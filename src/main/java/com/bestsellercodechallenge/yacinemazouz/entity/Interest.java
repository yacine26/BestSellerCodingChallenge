package com.bestsellercodechallenge.yacinemazouz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Interest {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn()
    private Game game = new Game();
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn()
    private Gamer gamer = new Gamer();
    private LevelType level;
    private int credit;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public LevelType getLevel() {
        return level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}

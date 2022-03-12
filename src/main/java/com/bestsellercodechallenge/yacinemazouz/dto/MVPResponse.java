package com.bestsellercodechallenge.yacinemazouz.dto;

import com.bestsellercodechallenge.yacinemazouz.entity.Gamer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MVPResponse {
    public Gamer gamer;
    public int credit;
}

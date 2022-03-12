package com.bestsellercodechallenge.yacinemazouz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatchmakingRequest {
    public String level;
    public String geography;
}

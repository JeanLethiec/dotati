package com.ceihtel.dotati.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    private Long leagueId;
    private String ticket;
    private String banner;
    private String tier;
    private String name;
}

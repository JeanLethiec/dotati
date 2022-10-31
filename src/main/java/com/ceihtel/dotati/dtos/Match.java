package com.ceihtel.dotati.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private Long match_id;
    private Long radiant_team_id;
    private Long dire_team_id;
    private Long series_id;
    private boolean radiant_win;
}

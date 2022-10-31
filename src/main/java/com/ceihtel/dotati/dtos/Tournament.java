package com.ceihtel.dotati.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament implements Comparable<Tournament> {
    private Long leagueid;
    private String name;

    @JsonIgnore
    public boolean isTheInternational() {
        return name.matches("The International [0-9]{4}");
    }

    @Override
    public int compareTo(Tournament o) {
        return getName().compareTo(o.getName());
    }
}

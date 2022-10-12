package com.projects.tidystore.daos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class PositionDao {
    @Getter
    @Setter
    private String name;
}

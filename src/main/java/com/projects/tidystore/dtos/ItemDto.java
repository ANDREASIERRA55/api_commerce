package com.projects.tidystore.dtos;

import lombok.Data;

@Data
public class ItemDto {

    private String shelving;
    private String section;
    private String position;
    private String box;
    private String name;
    private Long roomId;

}

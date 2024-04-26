package com.example.Diplom.Dto;

import com.example.Diplom.Model.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChosenPropertyDto {
    private Integer count;
    private Size chosenSize;
    private ColorDto chosenColor;
}

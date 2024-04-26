package com.example.Diplom.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_generator")
    @SequenceGenerator(name = "color_generator", sequenceName = "color_id_seq", allocationSize = 0)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "hex_view" )
    private String HEXView;

    //@ManyToMany(mappedBy = "colors")
    //private Set<Product> products = new LinkedHashSet<>();

}

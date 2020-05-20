package com.aliance.store.store.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="tbl_categories")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Datos autoincrementale
    private Long id;

    private String name;

}

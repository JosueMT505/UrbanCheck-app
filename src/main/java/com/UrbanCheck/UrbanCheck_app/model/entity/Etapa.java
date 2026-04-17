package com.UrbanCheck.UrbanCheck_app.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "etapas")

public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Se requiere el nombre de la etapa")
    @Size(min = 3, max = 30, message = "El nombre debe ser entre 3 y 30 caracteres")
    @Column(nullable = false)
    private String nombre_etapa;

}   

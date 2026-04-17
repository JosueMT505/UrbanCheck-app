package com.UrbanCheck.UrbanCheck_app.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "residentes")
public class Residente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false)
    private String nombres;

    @Email(message = "Debe proporcionar un email valido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "El telefono es obligatorio")
    @Column(nullable = false)
    private String telefono;

    @NotBlank(message = "El numero de la manzana es obligatorio")
    @Column(name = "numero_manzana", nullable = false)
    private String manzana;
    
    @NotBlank(message = "El numero de casa es obligatorio")
    @Column(name = "numero_casa", nullable = false)
    private String numeroCasa;

    // Campos de Auditoria 
    @Column(name= "creado_en", updatable = false)
    private LocalDateTime creadoEn;

    @Column(name= "actualizado_en")
    private LocalDateTime actualizadoEn;

    @PrePersist
    protected void onCreate() {
        creadoEn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        actualizadoEn = LocalDateTime.now();
    }
}

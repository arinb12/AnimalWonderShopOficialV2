package com.anws.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "pregunta")
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long idPregunta;
    private String detallePregunta;
    private String respuesta;
    private String nombreUsuario;

    // Constructor con y sin parametros
    public Pregunta() {
    }

    public Pregunta(String detallePregunta, String respuesta) {
        this.detallePregunta = detallePregunta;
        this.respuesta = respuesta;
    }


}
    
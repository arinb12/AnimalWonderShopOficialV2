package com.anws.service;

import com.anws.domain.Pregunta;
import java.util.List;

public interface PreguntaService {

    // Se obtiene un listado de preguntas en un List
    public List<Pregunta> getPreguntas();
    
    // Se obtiene un Pregunta, a partir del id de un pregunta
    public Pregunta getPregunta(Pregunta pregunta);

    // Se inserta un nuevo pregunta si el id del pregunta esta vacÃƒÂ­o
    // Se actualiza un pregunta si el id del pregunta NO esta vacÃƒÂ­o
    public void save(Pregunta pregunta);

    // Se elimina el pregunta que tiene el id pasado por parÃƒÂ¡metro
    public void delete(Pregunta pregunta);
        
}

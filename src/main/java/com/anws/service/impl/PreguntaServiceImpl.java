package com.anws.service.impl;

import com.anws.dao.PreguntaDao;
import com.anws.domain.Pregunta;
import com.anws.service.PreguntaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PreguntaServiceImpl implements PreguntaService {
    
    @Autowired
    private PreguntaDao preguntaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Pregunta> getPreguntas() {
        var lista=preguntaDao.findAll(); //Se va a guardar en esta lista
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Pregunta getPregunta(Pregunta pregunta) {
        return preguntaDao.findById(pregunta.getIdPregunta()).orElse(null);
    }

    @Override
    @Transactional //Metodo de tipo transaccional porque le voy a preguntar a la bd sobre la info si existe me la devuelve
    public void save(Pregunta pregunta) {
        preguntaDao.save(pregunta);
    }

    @Override
    @Transactional
    public void delete(Pregunta pregunta) {
        preguntaDao.delete(pregunta);
    }

}
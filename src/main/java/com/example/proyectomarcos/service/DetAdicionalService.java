package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.DetAdicional;
import com.example.proyectomarcos.repository.IDetAdicional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetAdicionalService {

    @Autowired
    private IDetAdicional IDetAdicional;

    public List<DetAdicional> getAllDetAdicional() {
        return IDetAdicional.findAll();
    }

    public Optional<DetAdicional> getDetAdicionalById(Integer id) {
        return IDetAdicional.findById(id);
    }

    public void save(DetAdicional detAdicional) {
        IDetAdicional.save(detAdicional);
    }

    public void deleteById(Integer id) {
        IDetAdicional.deleteById(id);
    }

}


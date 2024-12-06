package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.model.entity.Pizza;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.repository.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetPizzaService {

    @Autowired
    private IDetPizza IDetPizza;

    @Autowired
    private IPizza IPizza;

    public List<DetPizza> getAllDetPizza() {
        return IDetPizza.findAll();
    }

    public Optional<DetPizza> getDetPizzaById(Integer id) {
        return IDetPizza.findById(id);
    }

    public void save(DetPizza detPizza) {
        IDetPizza.save(detPizza);
    }

    public void deleteById(Integer id) {
        IDetPizza.deleteById(id);
    }


    public Integer verificarPizza(Pizza pizza) {
        List<Pizza> lista = IPizza.findAll();
        for (Pizza p : lista) {
            if (p.getIngrediente().equals(pizza.getIngrediente()) &&
                    p.getCarne().equals(pizza.getCarne()) &&
                    p.getMasa().equals(pizza.getMasa()) &&
                    p.getSalsa().equals(pizza.getSalsa()) &&
                    p.getQueso().equals(pizza.getQueso()) &&
                    p.getTamano().equals(pizza.getTamano())) {
                return p.getId();
            }
        }
        return null;
    }

    public int contarDetPizza(Integer id){

        int total = 0;
        List<DetPizza> listaPizzas = IDetPizza.findAllByOrdenId(id);
        for (DetPizza dp : listaPizzas) {
            total ++;
        }

        return total;
    }

}

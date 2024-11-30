package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.entity.Carne;
import com.example.proyectomarcos.model.entity.Ingrediente;
import com.example.proyectomarcos.model.entity.Pizza;
import com.example.proyectomarcos.repository.ICarne;
import com.example.proyectomarcos.repository.IIngrendiente;
import com.example.proyectomarcos.repository.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private IPizza IPizza;
    @Autowired
    private IIngrendiente IIngrendiente;
    @Autowired
    private ICarne ICarne;

    public List<Pizza> getAllPizzas() {
        return IPizza.findAll();
    }

    public Optional<Pizza> getPizzaById(Integer id) {
        return IPizza.findById(id);
    }

    public void savePizza(Pizza pizza) {
        IPizza.save(pizza);
    }

    public void deletePizzaById(Integer id) {
        IPizza.deleteById(id);
    }

    public Integer VerificarIngredientes(Ingrediente ingrediente) {
        List<Ingrediente> lista = IIngrendiente.findAll();
        for (Ingrediente i : lista) {
            if (i.getAceituna().equals(ingrediente.getAceituna()) &&
                i.getCebolla().equals(ingrediente.getCebolla()) &&
                i.getChampinon().equals(ingrediente.getChampinon()) &&
                i.getCheddar().equals(ingrediente.getCheddar()) &&
                i.getPimiento().equals(ingrediente.getPimiento()) &&
                i.getPina().equals(ingrediente.getPina()) ){
                return i.getId();
            }
        }
        return null;
    }

    public Integer VerificarCarnes(Carne carne) {
        List<Carne> lista = ICarne.findAll();
        for (Carne c : lista) {
            if (c.getItaliana().equals(carne.getItaliana()) &&
                c.getJamon().equals(carne.getJamon()) &&
                c.getMolida().equals(carne.getMolida()) &&
                c.getPollo().equals(carne.getPollo()) &&
                c.getPepperoni().equals(carne.getPepperoni()) &&
                c.getTocino().equals(carne.getTocino()) ){
                return c.getId();
            }
        }
        return null;
    }

}

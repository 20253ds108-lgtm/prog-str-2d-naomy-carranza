package com.example.demolistview.servises;

import com.example.demolistview.repositories.PersonFileRepository;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private PersonFileRepository  repo=new PersonFileRepository();
    public List<String> loadDataforList() throws IOException {
        List<String> lines=repo.readAllLines();//recupera las lineas del archivo
        List<String> result=new ArrayList<>();//el listado dde resultado con el formato deseado
        for (String line:lines){
            if (line==null || line.isBlank()) continue;//ignora las lineas nulas

            String[] parts=line.split(",",-1);
            String name=parts[0].trim();//obtiene el nombre del arreglo
            String correo=parts[1].trim();//obtiene el correo del arreglo

            result.add(name+"-"+correo);//se agrega a la lista de resultados con el formato deseado
        }
        return result;
    }
}

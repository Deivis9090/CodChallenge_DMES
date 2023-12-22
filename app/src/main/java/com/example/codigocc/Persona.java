package com.example.codigocc;

public class Persona {

    String Name, Gender, Age;
    int Image, Desc; // DESCRIPCION EN INT, YA QUE MANEJE STRINGS PARA SIMPLIFICAR EL CONTENIDO...

    public Persona(String name, String gender, int desc, String age, int image) {
        Name = name;
        Gender = gender;
        Desc = desc;
        Age = age;
        Image = image;
    }
}

package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarDireccion extends ComprobacionString{
    public ComprobarDireccion() {
    }

    @Override
    public void comprobacion(String direccion) throws InvalidException {
        if(direccion == null || direccion.trim().isEmpty()) throw new InvalidException("La dirección no puede estar vacía");
    }
}

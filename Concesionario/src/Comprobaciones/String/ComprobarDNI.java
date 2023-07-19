package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarDNI extends ComprobacionString{
    @Override
    public void comprobacion(String DNI) throws InvalidException {
        if (DNI == null) throw new InvalidException("El DNI no puede estar vacío");
        if(DNI.length() != 9 && DNI.matches("\\d{8}[A-Z]")) throw new InvalidException("El DNI ingresado es inválido");
    }
}

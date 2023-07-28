package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarDireccion extends ComprobacionString{
    public ComprobarDireccion() {
    }

    private static boolean containsNonNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void comprobacion(String direccion) throws InvalidException {
        if(direccion == null || direccion.trim().isEmpty()) throw new InvalidException("La dirección no puede estar vacía");
        if(!containsNonNumeric(direccion))System.out.println("La dirección no puede contener solo números");

    }
}

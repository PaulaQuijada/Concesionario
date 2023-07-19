package Comprobaciones.Int;

import Comprobaciones.Int.ComprobacionInt;
import Excepciones.InvalidException;

public class ComprobarTlf extends ComprobacionInt {
    @Override
    public void comprobacion(int telefono) throws InvalidException {
        if(telefono <9 && telefono >9) throw new InvalidException("El teléfono debe tener 9 cifras");
    }
}

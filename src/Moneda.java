
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Moneda {
    
    // Lista de opciones para convertir monedas
    private String[] listaDeCambios = {
        "De Soles a Dolares", 
        "De Soles a Euros", 
        "De Soles a Libras Esterlinas", 
        "De Soles a Yen", 
        "De Soles a Won",
        "De Dolares a Soles", 
        "De Euros a Soles", 
        "De Libras Esterlinas a Soles", 
        "De Yen a Soles",
        "De Won a Soles",
        };

    // Lista de razon de cambio 
    private double[] listaDeRatios = {
        //S/ -> $
        0.28,
        //S/ -> Eu 
        0.25,
        //S/ -> Lib
        0.21,
        //S/ -> Yen
        38.87,
        //S/ -> Won
        355.17,
        //$ -> S/
        3.61,
        //Eu -> S/
        4.02,
        //Lib -> S/
        4.68,
        //Yen -> S/
        0.026,
        //Won -> S/
        0.0028
        };

    // Lista de los simbolos monetarios
    private String[] simbolos = {"$","€","£","¥","\u20A9","S/.","S/.","S/.","S/.","S/."};

    private String opcion = null;

    private Double monto = null;

    private Double resultado;

    //Solicitar la opcion de cambion, retorna un objeto y convertirlo a un String.
    public Boolean getOpcion() {
        do{
            this.opcion = String.valueOf(JOptionPane.showInputDialog(null,"Escoja una opción","Opciones",JOptionPane.INFORMATION_MESSAGE, null, this.listaDeCambios, this.listaDeCambios[0]));
            if (this.opcion == "null"){
                JOptionPane.showMessageDialog(null,"Canceló operación","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                return true;
            }
        }while(this.opcion == "null");
    }

    //Solicitar el monto a calcular, convertirlo a un double
    public Boolean getMonto() {

        do {
            try{
                this.monto = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el valor a convertir"));
                return true;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Valor no válido","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }catch (NullPointerException e){
                JOptionPane.showMessageDialog(null,"Operación cancelada","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }while(this.monto == null);

    }

    //Retorna el calculo con un mensaje formateado
    public String resultado() {

        this.resultado = listaDeRatios[Arrays.asList(listaDeCambios).indexOf(opcion)] * monto;
        return this.simbolos[Arrays.asList(listaDeCambios).indexOf(opcion)] + " " + String.format("%,.2f",this.resultado) + this.opcion.substring(this.opcion.lastIndexOf("a ") + 1);

    }
}
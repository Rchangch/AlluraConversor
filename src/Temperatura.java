import java.util.Arrays;

import javax.swing.JOptionPane;

public class Temperatura {

        // Lista de opciones para convertir monedas
        private String[] listaDeCambios = {
            "De Centigrados a Fahrenheit", 
            "De Centigrados a Kelvin",
            "De Fahrenheit a Centigrados",
            "De Fahrenheit a Kelvin",
            "De Kelvin a Fahrenheit",
            "De Kelvin a Centigrados", 
            };
    
        // Lista de los simbolos monetarios
        private String[] simbolos = {"F°","K°","C°","K°","F°","C°",};

        private String opcion = null;

        private Double temperatura = null;

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

        public Boolean getTemperatura() {

            do {
                try{
                    this.temperatura = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el valor a convertir"));
                    return true;
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Valor no válido","Error",JOptionPane.ERROR_MESSAGE);
                    return false;
                }catch (NullPointerException e){
                    JOptionPane.showMessageDialog(null,"Operación cancelada","Error",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }while(this.temperatura == null);
    
        }

        public String resultado() {

            switch(opcion){
                case "De Centigrados a Fahrenheit" :
                    this.resultado = (this.temperatura * (9.0/5.0)) + 32.0;
                    break;
                case "De Centigrados a Kelvin":
                    this.resultado = this.temperatura + 273.15;
                    break;
                case "De Fahrenheit a Centigrados" :
                    this.resultado = (this.temperatura - 32) * (5.0/9.0);
                    break;
                case "De Fahrenheit a Kelvin" :
                    this.resultado = ((this.temperatura - 32) * (5.0/9.0)) + 273.15;
                    break;
                case "De Kelvin a Fahrenheit" :
                    this.resultado = ((this.temperatura - 273.15) * (9.0/5.0)) + 32;
                    break;
                case "De Kelvin a Centigrados" :
                    this.resultado = this.temperatura - 273.15;
                    break;
            }

            return String.format("%,.2f",this.resultado) + " " + simbolos[Arrays.asList(listaDeCambios).indexOf(opcion)] + " Grados" + opcion.substring(opcion.lastIndexOf("a ") + 1);
        }

}

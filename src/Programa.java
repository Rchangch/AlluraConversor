import javax.swing.JOptionPane;

public class Programa {
    
    public static void main(String[] args) {

        //Programa funcinara siempre que la variable continuar sea verdadero.
        boolean continuar = true;

        // Inicializar la lista de opciones de conversion
        Object[] tipoDeConversiones = {"Conversor de Moneda", "Conversor de Temperatura"};


        do{

            //Preguntar el tipo de conversion que se desee realizar y convertirlo en un String
            String tipoDeConversion = String.valueOf(JOptionPane.showInputDialog(null,"Escoja una opción","Conversion",JOptionPane.QUESTION_MESSAGE, null, tipoDeConversiones, tipoDeConversiones[0]));

            // Informar que se cancelo o que no se escogio una opcion de conversion y pregunta si desea continuar con el programa
            if (tipoDeConversion == "null"){
                int mensaje = JOptionPane.showConfirmDialog(null, "Canceló la operación ¿Desea continuar?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION);
                if (mensaje != 0){
                    continuar = false;
                    JOptionPane.showMessageDialog(null,"Programa Terminado");
                }
            }

            //Si se escogio un tipo de conversion
            else {

                switch(tipoDeConversion){
                    case "Conversor de Moneda":

                        //Inicilaizar una instancia de moneda
                        Moneda moneda = new Moneda();

                        //solicitar la opcion de cambio
                        if(moneda.getOpcion()){

                            //solicitar el monto a cambiar
                            if(moneda.getMonto()){
                                //Mostrar el resultado
                                JOptionPane.showMessageDialog(null,moneda.resultado());
                                break;
                            }
                            break;
                        }
                        break;
                    case "Conversor de Temperatura":
                        
                        Temperatura temperatura = new Temperatura();
                        if(temperatura.getOpcion()){
                            if(temperatura.getTemperatura()){
                                JOptionPane.showMessageDialog(null,temperatura.resultado());
                                break;
                            }
                            break;
                        }
                        break;
                        
                }
                int deseaContinuar = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION);

                if (deseaContinuar !=0){
                    continuar = false;
                    JOptionPane.showMessageDialog(null,"Programa Terminado");
                }
            }
        }
        while (continuar);
    }

}


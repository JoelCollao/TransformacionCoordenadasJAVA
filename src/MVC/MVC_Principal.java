
package MVC;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.FormCoordenadasT;

public class MVC_Principal {
    public static void main(String[] args) {
        
        Modelo model = new Modelo();
        FormCoordenadasT vista = new FormCoordenadasT();
        Controlador ctrl = new Controlador(vista, model);
        ctrl.Iniciar();
        vista.setVisible(true);
            
    }
}

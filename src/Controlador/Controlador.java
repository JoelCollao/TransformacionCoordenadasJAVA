
package Controlador;

import Modelo.Modelo;
import Vista.FormCoordenadasT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{ // implements ActionListener : escucha los eventos de algun botón

    private FormCoordenadasT Vista;
    private Modelo Modelo;
     
    public Controlador(FormCoordenadasT Vista,Modelo Modelo){
        this.Vista = Vista;
        this.Modelo = Modelo;
        this.Vista.cbCalcular.addActionListener(this);
    }
    
    public void Iniciar(){
        Vista.setTitle("MVC Transformador de Coordenadas");
        Vista.setLocationRelativeTo(null);  
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //GRADOS MINUTOS SEGUNDOS DE LATITUD
        Modelo.setGradosLatitud(Double.parseDouble(Vista.txtGradoLati.getText()));
        Modelo.setMinutosLatitud(Double.parseDouble(Vista.txtMinuLati.getText()));
        Modelo.setSegundosLatitud(Double.parseDouble(Vista.txtSegLati.getText()));
        
        //GRADOS MINUTOS SEGUNDOS DE LONGITUD
        Modelo.setGradosLongitud(Double.parseDouble(Vista.txtGradoLongi.getText()));
        Modelo.setMinutosLongitud(Double.parseDouble(Vista.txtMinuLongi.getText()));
        Modelo.setSegundosLongitud(Double.parseDouble(Vista.txtSegLongi.getText()));
        
        Modelo.TransformacionCoordendasX();
        Modelo.TransformacionCoordendasY();
        
        Vista.txtEste.setText(String.valueOf(Modelo.getCoordenadaEste()));
        Vista.txtEste11.setText(String.valueOf(Modelo.getCoordenadaNorte()));
        
        FormCoordenadasT datos = new FormCoordenadasT();       
    }
       
}

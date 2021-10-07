
package Modelo;

import Vista.FormCoordenadasT;

public class Modelo {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private double GradosLatitud;
    private double MinutosLatitud;
    private double SegundosLatitud;

    private double GradosLongitud;
    private double MinutosLongitud;
    private double SegundosLongitud;
    
    private double CoordenadaEste;
    private double CoordenadaNorte;
    
    private String Norte;
    private String Sur;
    
    
    private String Oriente;
    private String Occidente;
    
    private double coordDeciLati;
    private double coordDeciLongi;
    

    public double getCoordDeciLati() {
        return coordDeciLati;
    }

    public void setCoordDeciLati(double coordDeciLati) {
        this.coordDeciLati = coordDeciLati;
    }

    public double getCoordDeciLongi() {
        return coordDeciLongi;
    }

    public void setCoordDeciLongi(double coordDeciLongi) {
        this.coordDeciLongi = coordDeciLongi;
    }

    public double getGradosLatitud() {
        return GradosLatitud;
    }

    public void setGradosLatitud(double GradosLatitud) {
        this.GradosLatitud = GradosLatitud;
    }

    public double getMinutosLatitud() {
        return MinutosLatitud;
    }

    public void setMinutosLatitud(double MinutosLatitud) {
        this.MinutosLatitud = MinutosLatitud;
    }

    public double getSegundosLatitud() {
        return SegundosLatitud;
    }

    public void setSegundosLatitud(double SegundosLatitud) {
        this.SegundosLatitud = SegundosLatitud;
    }

    public double getGradosLongitud() {
        return GradosLongitud;
    }

    public void setGradosLongitud(double GradosLongitud) {
        this.GradosLongitud = GradosLongitud;
    }

    public double getMinutosLongitud() {
        return MinutosLongitud;
    }

    public void setMinutosLongitud(double MinutosLongitud) {
        this.MinutosLongitud = MinutosLongitud;
    }

    public double getSegundosLongitud() {
        return SegundosLongitud;
    }

    public void setSegundosLongitud(double SegundosLongitud) {
        this.SegundosLongitud = SegundosLongitud;
    }

    public double getCoordenadaEste() {
        return CoordenadaEste;
    }

    public void setCoordenadaEste(double CoordenadaEste) {
        this.CoordenadaEste = CoordenadaEste;
    }

    public double getCoordenadaNorte() {
        return CoordenadaNorte;
    }

    public void setCoordenadaNorte(double CoordenadaNorte) {
        this.CoordenadaNorte = CoordenadaNorte;
    }

    public String getNorte() {
        return Norte;
    }

    public void setNorte(String Norte) {
        this.Norte = Norte;
    }

    public String getSur() {
        return Sur;
    }

    public void setSur(String Sur) {
        this.Sur = Sur;
    }

    public String getOriente() {
        return Oriente;
    }

    public void setOriente(String Oriente) {
        this.Oriente = Oriente;
    }

    public String getOccidente() {
        return Occidente;
    }

    public void setOccidente(String Occidente) {
        this.Occidente = Occidente;
    }
    
    public double TransformacionCoordendasX(){
        
        this.coordDeciLati = (this.GradosLatitud)+(this.MinutosLatitud/60)+(this.SegundosLatitud/3600);
        this.coordDeciLongi = (this.GradosLongitud)+(this.MinutosLongitud/60)+(this.SegundosLongitud/3600);

        double yg,xg,yr, xr, huso, meridiano, a, b, ex, sex, sex2, c, dl, pi, na, xi, eta, zeta, a1, a2, j2, j4, ni, k, j6, alfa, beta, gama, bfi, utmx, utmy,temp;
        double constanPI;
        yg = this.coordDeciLati*(-1);
        xg = this.coordDeciLongi*(-1);

        System.out.println("El valor de latitud decimales es :"+yg);
        System.out.println("El valor de longitud decimales es :"+xg);
 
        constanPI = 3.14159265358979;   // VALOR DE PI
        yr = yg*constanPI/180;
        System.out.println(yr);
        
        xr = xg*constanPI/180;
        System.out.println(xr);
        
        temp = xg/6+31; // VALOR TEMPORAL
        System.out.println(temp);
        
        if(Math.round(temp)-temp < 0){
            huso = Math.round(temp);
            System.out.println("El uso es :"+huso);
        }else{
            huso = Math.round(temp)-1;
            System.out.println("El uso es :"+huso);
        }
        
        meridiano = 6 * huso - 183;
        System.out.println("El meridiano es :"+meridiano);
        
        a = 6378137;
        System.out.println("EL valor de a es: "+a);
        
        b = 6356752.31425;
        System.out.println("El valor de b es:"+b);
        
        ex = Math.sqrt(a * a - b * b)/a;
        System.out.println("El valor de ex es :"+ex);
        
        sex = Math.sqrt(a * a - b * b)/b;
        System.out.println("El valor de sex es:"+sex);
        
        sex2 = sex * sex;
        System.out.println("EL valor de sex2 :"+sex2);
            
        c = a * a/b;
        System.out.println("El valor de c es :"+c);
        
        dl = (xg-meridiano)*constanPI/180;
        System.out.println("El valor de dl :"+dl);
           
        na = Math.cos(yr)*Math.sin(dl);
        System.out.println("El valor de na es:"+na);
        
        xi = 0.5 * Math.log((1+na)/(1-na));
        System.out.println("El valor de xi es : "+ xi);
        
        eta = Math.atan(Math.tan(yr)/Math.cos(dl))-yr;
        System.out.println("El valor de eta es : "+eta);
                  
        zeta = 0.5 * sex2 * xi * xi * Math.pow(Math.cos(yr),2);
        System.out.println("El valor de zeta es :"+zeta);
            
        k = 0.9996; // El cilindro de proyección UTM es secante al elipsoide, de esa forma el factor de deformación K, puede variar desde 0.9996 en el meridiano central, pasando por deformación nula (K =1), hasta K mayor que 1     
        System.out.println("El valor de k es: "+k);
            
        ni = k * c / Math.sqrt(1 + sex2 * (Math.pow(Math.cos(yr),2)));
        System.out.println("El valor de ni es :"+ni);
            
        a1 = Math.sin(2*yr);
        System.out.println("El valor de a1 es :"+a1);      
       
        a2 = a1 * Math.pow((Math.cos(yr)),2);
         System.out.println("El valor de a2 es :"+a2);
   
        j2 = yr + a1/2;
        System.out.println("El valor de j2 es : "+j2);
        
        j4 = (3*j2+a2)/4;
        System.out.println("El valor de j4 es :"+j4);

        j6 = (5*j4+a2*(Math.pow(Math.cos(yr), 2)))/3;
        System.out.println("El valor de j6 es :"+j6);
        
        alfa = 3 * sex2/4;
        System.out.println("El valor de alfa es :"+alfa);
 
        beta = 5 * (Math.pow(alfa, 2)/3);
        System.out.println("El valor de beta es :"+beta);

        gama = 1.296296296 * (Math.pow(alfa,3));
        System.out.println("el valor de gama es :"+gama);
        
        bfi = k * c *(yr-alfa*j2+beta*j4-gama*j6);
        System.out.println("El valor de bfi es :"+bfi);

        utmx = xi * ni * (1+zeta/3)+500000;
        System.out.println("El valor de UTMX es "+utmx);
        
        //utmy = -1336859.30087329
        // utmy = 8663140.69912671
        utmy = eta * ni * (1+zeta)+bfi;
        System.out.println("El valor de UTMY es:"+utmy);
         
        utmy = 10000000 + utmy;
        System.out.println("El valor de UTMY es:"+utmy);
            
        this.CoordenadaEste = utmx;
        return  this.CoordenadaEste;
  
    }
     
     public double TransformacionCoordendasY(){
        
        this.coordDeciLati = (this.GradosLatitud)+(this.MinutosLatitud/60)+(this.SegundosLatitud/3600);
        this.coordDeciLongi = (this.GradosLongitud)+(this.MinutosLongitud/60)+(this.SegundosLongitud/3600);

        double yg,xg,yr, xr, huso, meridiano, a, b, ex, sex, sex2, c, dl, pi, na, xi, eta, zeta, a1, a2, j2, j4, ni, k, j6, alfa, beta, gama, bfi, utmx, utmy,temp;
        double constanPI;
        yg = this.coordDeciLati*(-1);
        xg = this.coordDeciLongi*(-1);

        System.out.println("El valor de latitud decimales es :"+yg);
        System.out.println("El valor de longitud decimales es :"+xg);
 
        constanPI = 3.14159265358979;   // VALOR DE PI
        yr = yg*constanPI/180;
        System.out.println(yr);
        
        xr = xg*constanPI/180;
        System.out.println(xr);
        
        temp = xg/6+31; // VALOR TEMPORAL
        System.out.println(temp);
        
        if(Math.round(temp)-temp < 0){
            huso = Math.round(temp);
            System.out.println("El uso es :"+huso);
        }else{
            huso = Math.round(temp)-1;
            System.out.println("El uso es :"+huso);
        }
        
        meridiano = 6 * huso - 183;
        System.out.println("El meridiano es :"+meridiano);
        
        a = 6378137;
        System.out.println("EL valor de a es: "+a);
        
        b = 6356752.31425;
        System.out.println("El valor de b es:"+b);
        
        ex = Math.sqrt(a * a - b * b)/a;
        System.out.println("El valor de ex es :"+ex);
        
        sex = Math.sqrt(a * a - b * b)/b;
        System.out.println("El valor de sex es:"+sex);
        
        sex2 = sex * sex;
        System.out.println("EL valor de sex2 :"+sex2);
            
        c = a * a/b;
        System.out.println("El valor de c es :"+c);
        
        dl = (xg-meridiano)*constanPI/180;
        System.out.println("El valor de dl :"+dl);
           
        na = Math.cos(yr)*Math.sin(dl);
        System.out.println("El valor de na es:"+na);
        
        xi = 0.5 * Math.log((1+na)/(1-na));
        System.out.println("El valor de xi es : "+ xi);
        
        eta = Math.atan(Math.tan(yr)/Math.cos(dl))-yr;
        System.out.println("El valor de eta es : "+eta);
                  
        zeta = 0.5 * sex2 * xi * xi * Math.pow(Math.cos(yr),2);
        System.out.println("El valor de zeta es :"+zeta);
            
        k = 0.9996; // El cilindro de proyección UTM es secante al elipsoide, de esa forma el factor de deformación K, puede variar desde 0.9996 en el meridiano central, pasando por deformación nula (K =1), hasta K mayor que 1     
        System.out.println("El valor de k es: "+k);
            
        ni = k * c / Math.sqrt(1 + sex2 * (Math.pow(Math.cos(yr),2)));
        System.out.println("El valor de ni es :"+ni);
            
        a1 = Math.sin(2*yr);
        System.out.println("El valor de a1 es :"+a1);      
       
        a2 = a1 * Math.pow((Math.cos(yr)),2);
         System.out.println("El valor de a2 es :"+a2);
   
        j2 = yr + a1/2;
        System.out.println("El valor de j2 es : "+j2);
        
        j4 = (3*j2+a2)/4;
        System.out.println("El valor de j4 es :"+j4);

        // verfificar sale excel:-0.807528565112473
        j6 = (5*j4+a2*(Math.pow(Math.cos(yr), 2)))/3;
        System.out.println("El valor de j6 es :"+j6);
        
        // esta bien 
        alfa = 3 * sex2/4;
        System.out.println("El valor de alfa es :"+alfa);
        
        // esta bien
        beta = 5 * (Math.pow(alfa, 2)/3);
        System.out.println("El valor de beta es :"+beta);
        
        //
        gama = 1.296296296 * (Math.pow(alfa,3));
        System.out.println("el valor de gama es :"+gama);
        
        // verfiicar excel sale : -1336075.65668308
        bfi = k * c *(yr-alfa*j2+beta*j4-gama*j6);
        System.out.println("El valor de bfi es :"+bfi);
        
        //283974.082060169
        utmx = xi * ni * (1+zeta/3)+500000;
        System.out.println("El valor de UTMX es "+utmx);
        
        //utmy = -1336859.30087329
        // utmy = 8663140.69912671
        utmy = eta * ni * (1+zeta)+bfi;
        System.out.println("El valor de UTMY es:"+utmy);
         
        utmy = 10000000 + utmy;
        System.out.println("El valor de UTMY es:"+utmy);
            
        this.CoordenadaNorte = utmy;
        return  this.CoordenadaNorte;
    
    }
     
    public void Calculos(){
    
       
        
    }
    
    
    
}

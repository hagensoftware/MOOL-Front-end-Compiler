import java.lang.*;
import java.io.*;
import java.util.*;

public class Tokenizador { 
    public int PosActual;
    private int PosNueva;
    private int PosMax;
    private String str;
    private String alfa;
    private String num;
    private String delimitadores;
    private String operadores;    
    private String relacionales;    
    private String eq, OrOp, AndOp, NotOp, AddOp, MulOp, Slash, plus, minus;    
    
    public static int tipo;
    
    private int estado;

    public Tokenizador(String str) { 
	PosActual = 0;
	PosNueva = -1;
	this.str = str;
	PosMax = str.length();
        alfa="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        num="0123456789";
	delimitadores = " \t\n\r\f"; 
        relacionales= "=!><";
        operadores = "=!><.,:;/[]{}()!%&*_+|-";
        AndOp="&";
        OrOp="|";
        AddOp="+-";
        NotOp="!";
        MulOp="*/%";
        Slash="/";
        plus="+";
        minus="-";  
    }
    
    private int brincaDelimitador(int PosInicial) {
        int posicion = PosInicial;
	while (posicion < PosMax) {
            char c = str.charAt(posicion);
                if (Slash.indexOf(c)>=0 && scanNextChar(posicion+1) == '/') {
                    tipo=5;   // comentarios
                    posicion=PosMax;
                    break;
                }
            if (delimitadores.indexOf(c) < 0) break;           
            posicion++;
	}
        return posicion;
    }

    private int scanToken(int PosInicial) {
        int posicion = PosInicial;
        boolean yaentro=false;
        tipo=-1;
        while (posicion < PosMax) {
            char c = str.charAt(posicion);
//            System.out.println ((int)c);
            if (delimitadores.indexOf(c) >= 0)  
                break;

            else if (alfa.indexOf(c)>=0)
            {
                //System.out.println ("ALFA");
                estado= 1; // inicia alfa
                tipo=0; // tipo alfanumérico
            }
            
            else if (num.indexOf(c)>=0)
            {
                    if (tipo!=0) 
                    {
                        tipo=1;
                        //System.out.println ("NUM");
                    }
                    //else System.out.println ("ALFA");
                    estado=1;

            }
            
//            if (scanNextChar(posicion) == '"') break;
            
            else if (operadores.indexOf(c)>=0)
            {
                
                if (tipo==3) // oprel
                {
                    break;   
                }
                
                if ((tipo==0 || tipo==1) && estado!=2)  //alfa || num
                {
                    estado=2;
                    break;
                }

                if (plus.indexOf(c)>=0 && scanNextChar(posicion+1) == '+') 
                {
                    tipo=6;
                    posicion++;
                    posicion++;
                    //System.out.println ("REL");
                }
                if (minus.indexOf(c)>=0 && scanNextChar(posicion+1) == '-') 
                {
                    tipo=6;
                    posicion++;
                    posicion++;
                    //System.out.println ("REL");
                }
                
                
                if (relacionales.indexOf(c)>=0 && scanNextChar(posicion+1) == '=') 
                {
                    tipo=3;
                    posicion++;
                    posicion++;
                    //System.out.println ("REL");
                }
                
                else if (AndOp.indexOf(c)>=0 && scanNextChar(posicion+1) == '&') 
                {
                    tipo=4;
                    posicion++;
                    posicion++;
                    //System.out.println ("ANDOP");
                }
/*
                else if (Slash.indexOf(c)>=0 && scanNextChar(posicion+1) == '/') 
                {
                    tipo=5;
                    posicion=PosMax;
                    System.out.println ("COMMENT");                    
                    break;
                    //posicion++;

                }
 */

                
                
                else if (relacionales.indexOf(c)>=0)
                {
                    tipo=2;
                    //System.out.println ("ARITM");
                }
                else
                {
                    tipo=2;
                    //System.out.println ("OPER");
                }  
                break;
            }

            

            else if ((int)c==8220 || (int)c==34) 
                {
 //               System.out.println ("comillas'''''''''''''''''''''''''''''''");
                    tipo=5;
                    int p=posicion+1;
                    while((int)scanNextChar(p)!=8220 && (int)scanNextChar(p)!=34 && (int)scanNextChar(p)!=8221){
 //                       System.out.println ((int)scanNextChar(p));
                        ++p;
                    
                        //break;
                    }
                    //System.out.println ("salir");
                    posicion=p+1;
                    break;
                    //System.out.println ("STRING ================================"+p);
                }
            
            posicion++;
	}
	if (PosInicial == posicion) {
            char c;
            c = str.charAt(posicion);
	    if (delimitadores.indexOf(c) >= 0 || operadores.indexOf(c) >= 0)
                posicion++;
        }
        return posicion;
    }

    public boolean tieneMasTokens() {
	PosNueva = brincaDelimitador(PosActual);
	return (PosNueva < PosMax);
    }

    public String sigToken() {
	PosActual = (PosNueva >= 0) ?  
	    PosNueva : brincaDelimitador(PosActual);
	PosNueva = -1;
 	int comienzo = PosActual;
	PosActual = scanToken(PosActual);
	return str.substring(comienzo, PosActual);
    }

    public String sigPos() {
	PosActual = (PosNueva >= 0) ?  
	    PosNueva : brincaDelimitador(PosActual);
	PosNueva = -1;
 	int comienzo = PosActual;
	PosActual = scanChar(PosActual);
	return str.substring(comienzo, PosActual);
    }

    private char scanChar(int PosInicial) {
        int posicion=PosInicial;
        char c = str.charAt(posicion);
        return c;
    }

    private char scanNextChar(int PosInicial) {
        int posicion=PosInicial;
        char c2 = str.charAt(posicion);
        return c2;
    }    
    
    private int getToken(int PosInicial) {

        int posicion = PosInicial;
        while (posicion < PosMax) {
            char c = str.charAt(posicion);
            if (delimitadores.indexOf(c) >= 0)
                break;
            posicion++;
            if (operadores.indexOf(c) >= 0)
                break;
            posicion++;
        }
	if (PosInicial == posicion) {
            char c = str.charAt(posicion);
	    if (delimitadores.indexOf(c) >= 0)
                posicion++;
        }
        return posicion;
    }
}

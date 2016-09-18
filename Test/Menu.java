/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package My;

/**
 *
 * @author Nayara
 */
public class Menu {
    public int  vertex;
    public int position(String local ){
        switch(local){
            case "Entrada":
                vertex = 0;  
                   break;   
            case "Didatica 1": 
                vertex = 1;  
                break;  
            case "Didatica 2":
                vertex = 2;
                break;
            case "Didatica 3":
                vertex = 3;  
                   break;   
            case "Didatica 4": 
                vertex = 4;  
                break;  
            case "Didadica 5":
                vertex = 5;
                break;
            case "Didatica 6":
                vertex = 6;  
                break;   
            case "MOURA": 
                vertex = 7;  
                break;  
            case "RESUN":
                vertex = 8;
                break;
            case "BICEN":
                vertex = 9;  
                break;   
            case "REITORIA": 
                vertex = 10;  
                break;  
            case "CCET":
                vertex = 11;
                break;
            case "CCBS":
                vertex = 12;
                break;
            case "DCE":
                vertex = 13;  
                break;   
            case "CENTRO DE VIVENCIA": 
                vertex = 14;  
                break;  
            case "LABORATORIO ESTUDOS RURAIS":
                vertex = 15;
                break;
             case "CECH 1":
                vertex = 16;
                break;
            case "DEP B":
                vertex = 17;  
                break;   
            case "DEP A": 
                vertex = 18;  
                break;  
            default: System.out.println("Local ainda não cadastrado");  
        }
        return vertex;
    }
    
}

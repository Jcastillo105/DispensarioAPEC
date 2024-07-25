/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.controller;

/**
 *
 * @author josee
 */
class CedulaValidator {
  
     public static boolean validaCedula(String pCedula) {
        int vnTotal = 0;
        String vcCedula = pCedula.replace("-", "");
        int pLongCed = vcCedula.trim().length();
        int[] digitoMult = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1};

        if (pLongCed != 11) {
            return false;
        }

        for (int vDig = 1; vDig <= pLongCed; vDig++) {
            int vCalculo = Integer.parseInt(vcCedula.substring(vDig - 1, vDig)) * digitoMult[vDig - 1];
            if (vCalculo < 10) {
                vnTotal += vCalculo;
            } else {
                vnTotal += Integer.parseInt(String.valueOf(vCalculo).substring(0, 1)) + Integer.parseInt(String.valueOf(vCalculo).substring(1, 2));
            }
        }

        return (vnTotal % 10 == 0);
    }
    
}

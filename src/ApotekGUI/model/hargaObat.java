/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApotekGUI.model;

/**
 *
 * @author USER
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhammadfandu
 */
public class hargaObat {
    private float hargaA;
    private float hargaB;
    private float jumlah;

    public hargaObat(float hargaA, float hargaB, float jumlah) {
        this.hargaA = hargaA;
        this.hargaB = hargaB;
        this.jumlah = jumlah;
    }

    public float getHargaA() {
        return hargaA;
    }

    public void setHargaA(float hargaA) {
        this.hargaA = hargaA;
    }

    public float getHargaB() {
        return hargaB;
    }

    public void setHargaB(float hargaB) {
        this.hargaB = hargaB;
    }

    public float getJumlah() {
        return jumlah;
    }

    public void setJumlah(float jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
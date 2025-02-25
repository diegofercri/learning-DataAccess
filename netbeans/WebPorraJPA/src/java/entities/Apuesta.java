/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author diurno
 */
public class Apuesta {
    private Integer golesl;
    private Integer golesv;
    private Long cuantas;

    public Apuesta() {
    }

    public Apuesta(Integer golesl, Integer golesv, Long cuantas) {
        this.golesl = golesl;
        this.golesv = golesv;
        this.cuantas = cuantas;
    }

    public Integer getGolesl() {
        return golesl;
    }

    public void setGolesl(Integer golesl) {
        this.golesl = golesl;
    }

    public Integer getGolesv() {
        return golesv;
    }

    public void setGolesv(Integer golesv) {
        this.golesv = golesv;
    }

    public Long getCuantas() {
        return cuantas;
    }

    public void setCuantas(Long cuantas) {
        this.cuantas = cuantas;
    }

    @Override
    public String toString() {
        return "Apuesta{" + "golesl=" + golesl + ", golesv=" + golesv + ", cuantas=" + cuantas + '}';
    }
    

}

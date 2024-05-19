/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author Salvador Hernández
 */
public class EstadoHabitacionServicio {

    private int id_estado_habitacion;
    private String Detalle_estado;

    public EstadoHabitacionServicio() {
    }

    public EstadoHabitacionServicio(int id_estado_habitacion, String Detalle_estado) {
        this.id_estado_habitacion = id_estado_habitacion;
        this.Detalle_estado = Detalle_estado;
    }

    public int getId_estado_habitacion() {
        return id_estado_habitacion;
    }

    public void setId_estado_habitacion(int id_estado_habitacion) {
        this.id_estado_habitacion = id_estado_habitacion;
    }

    public String getDetalle_estado() {
        return Detalle_estado;
    }

    public void setDetalle_estado(String Detalle_estado) {
        this.Detalle_estado = Detalle_estado;
    }

}

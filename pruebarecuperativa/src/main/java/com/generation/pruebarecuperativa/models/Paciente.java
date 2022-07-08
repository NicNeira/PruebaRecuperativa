package com.generation.pruebarecuperativa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//Definimos El objeto paciente como entidad
@Entity
@Table(name = "pacientes") // Creamos la tabla "pacientes"
public class Paciente {
    //Atributos

    // Cuando se agrege un elemnto este tendra un id PK e ira aumentando automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String rut;
    private String nombre;
    private Date fechaNacimiento;

    //One To Many de pacientes a citaMedica
    @OneToMany(mappedBy ="paciente",cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
    private List<CitaMedica> listaCitas;

    // opcionales, sirven para la gestion de la base dato
	@Column(updatable = false) // esta columna especifica nunca se va a actualizar atravez del sistema
	private Date createdAt;// Para saber en que momento fue insertada en la base de datos
	private Date updatedAt;// Para cuando se actualizo

    //Constructor vacio
    public Paciente() {
    }

    //Constructor con parametros
    public Paciente(String rut, String nombre, Date fechaNacimiento, List<CitaMedica> listaCitas) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.listaCitas = listaCitas;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<CitaMedica> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<CitaMedica> listaCitas) {
        this.listaCitas = listaCitas;
    }

    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    
    
    
}

package com.generation.pruebarecuperativa.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity //Definimos el objeto CitaMedica como entidad
@Table(name="citasMedicas") // Creamos la tabla "citasMedicas"
public class CitaMedica {
    
    //Atributos

    // Cuando se agrege un elemnto este tendra un id PK e ira aumentando automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private Date hora;
    private String areaMedica;

    //ManyToOne de citas medicas a paciente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id") // La FK quedara guardada en la tabla "citasMedicas"
	private Paciente paciente;

    // opcionales, sirven para la gestion de la base dato
	@Column(updatable = false) // esta columna especifica nunca se va a actualizar atravez del sistema
	private Date createdAt;// Para saber en que momento fue insertada en la base de datos
	private Date updatedAt;// Para cuando se actualizo

    //Constuctor vacio
    public CitaMedica() {
    }

    //Constructor con parametros
    public CitaMedica(Date hora, String areaMedica, Paciente paciente) {
        this.hora = hora;
        this.areaMedica = areaMedica;
        this.paciente = paciente;
    }

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getAreaMedica() {
        return areaMedica;
    }

    public void setAreaMedica(String areaMedica) {
        this.areaMedica = areaMedica;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

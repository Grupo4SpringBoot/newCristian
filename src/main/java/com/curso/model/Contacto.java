package com.curso.model;

// Getter, Setter y NoArgsConstructor proceden de Lombok, que Maven descarga con el pom.xml.
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * S11-1 Práctica 1: Clase Contacto
 *
 * Objetivo: representar a una persona de una agenda de contactos.
 *
 * Lo que hace este ejemplo:
 *   - Guarda el nombre, el correo electrónico y el teléfono del contacto
 *   - Lombok genera los getters, los setters y el constructor vacío
 *   - Ofrece resumen() y emailValido()
 *
 * Concepto clave: es una clase Java normal, sin JPA. Solo necesitamos un código
 * sencillo al que hacer cambios y guardarlos con Git.
 */
// @Getter y @Setter generan un getter y un setter por cada campo.
// @NoArgsConstructor genera el constructor sin parámetros.
@Getter
@Setter
@NoArgsConstructor
public class Contacto {

    private String nombre;
    private String email;
    private String telefono;

    // Constructor con los tres datos del contacto.
    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * Devuelve el contacto en una sola línea: el nombre y, entre paréntesis, el correo y el teléfono.
     *
     * Ejemplo:
     *   resumen()  →  "Lucía Pérez (lucia@example.com, 600123456)"
     *
     * @return el texto con los tres datos del contacto
     */
    public String resumen() {
        // Concatenamos los tres datos con los separadores que queremos entre ellos.
        return nombre + " (" + email + ", " + telefono + ")";
    }

    /**
     * Comprueba que el correo tiene un aspecto razonable.
     *
     * Ejemplo:
     *   "lucia@example.com"   →  true
     *   "lucia@example"       →  false (no tiene punto)
     *   "lucia @example.com"  →  false (tiene un espacio)
     *
     * @return true si el correo tiene @, tiene punto y no tiene espacios
     */
    public boolean emailValido() {
        // contains() devuelve true si el texto contiene la cadena indicada.
        // El operador && exige que se cumplan las tres condiciones a la vez.
        return email.contains("@") && email.contains(".") && !email.contains(" ");
    }

}

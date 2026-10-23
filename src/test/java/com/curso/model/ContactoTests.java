package com.curso.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * S11-1 Práctica 1: Tests de la clase Contacto
 *
 * Objetivo: comprobar que Contacto guarda y devuelve sus datos y que sus métodos
 * hacen lo esperado.
 */
class ContactoTests {

    // Comprueba que el constructor guarda los datos y que los getters los devuelven.
    @Test
    void guardaLosDatos() {
        Contacto contacto = new Contacto("Lucía Pérez", "lucia@example.com", "600123456");

        assertEquals("Lucía Pérez", contacto.getNombre());
        assertEquals("lucia@example.com", contacto.getEmail());
        assertEquals("600123456", contacto.getTelefono());
    }

    // Comprueba que el setter cambia el valor del campo.
    @Test
    void cambiaElEmail() {
        Contacto contacto = new Contacto("Lucía Pérez", "lucia@example.com", "600123456");

        contacto.setEmail("lucia.perez@example.com");

        assertEquals("lucia.perez@example.com", contacto.getEmail());
    }

    // Comprueba que resumen() une el nombre, el correo y el teléfono.
    @Test
    void resumenIncluyeEmailYTelefono() {
        Contacto contacto = new Contacto("Lucía Pérez", "lucia@example.com", "600123456");

        assertEquals("Lucía Pérez (lucia@example.com, 600123456)", contacto.resumen());
    }

    // Comprueba que un correo correcto es válido.
    @Test
    void emailCorrectoEsValido() {
        Contacto contacto = new Contacto("Lucía Pérez", "lucia@example.com", "600123456");

        assertTrue(contacto.emailValido());
    }

    // Comprueba que un correo sin punto o con espacios no es válido.
    @Test
    void emailSinPuntoOConEspaciosNoEsValido() {
        assertFalse(new Contacto("Lucía Pérez", "lucia@example", "600123456").emailValido());
        assertFalse(new Contacto("Lucía Pérez", "lucia @example.com", "600123456").emailValido());
    }

}

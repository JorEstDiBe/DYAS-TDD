/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.dyas.tdd.registry;

/**
 *
 * @author Laura
 */
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    
    /*
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }*/

    // ---------- PRUEBAS PARA LAS CLASES DE EQUIVALENCIA -------------
    
    
    //Persona valida
    @Test
    public void testValidVoter() {
        Person person = new Person("Juan", 123, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    // Persona muerta
    @Test
    public void testDeadPerson() {
        Person person = new Person("Ana", 124, 40, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    
    // Persona menor de edad
    @Test
    public void testUnderagePerson() {
        Person person = new Person("Luis", 125, 16, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    
    //Persona con edad invalida
    @Test
    public void testInvalidAge() {
        Person person = new Person("Maria", 126, -5, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    // Persona duplicada
    @Test
    public void testDuplicatedPerson() {
        Person person = new Person("Carlos", 127, 25, Gender.MALE, true);
        RegisterResult firstResult = registry.registerVoter(person);
        RegisterResult secondResult = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, firstResult);
        Assert.assertEquals(RegisterResult.DUPLICATED, secondResult);
    }

    // ID igual a cero
    @Test
    public void testZeroId() {
        Person person = new Person("Sara", 0, 30, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result); // También lo permite
    }

    // Género: UNIDENTIFIED
    @Test
    public void testUnidentifiedGender() {
        Person person = new Person("Alex", 128, 28, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result); // El sistema lo permite
    }

    // Nombre vacío
    @Test
    public void testEmptyName() {
        Person person = new Person("", 129, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result); // No hay validación de nombre
    }

    // Nombre null
    @Test
    public void testNullName() {
        Person person = new Person(null, 130, 40, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result); // Si se permite, pasa
    }

}
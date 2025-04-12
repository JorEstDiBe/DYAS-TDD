/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Laura
 */
public class Registry {
    private Set<Integer> registeredIds = new HashSet<>();
    
    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }

        if (p.getAge() < 0) {
            return RegisterResult.INVALID_AGE;
        }

        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        if (registeredIds.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }

        registeredIds.add(p.getId());
        return RegisterResult.VALID;
    }
}
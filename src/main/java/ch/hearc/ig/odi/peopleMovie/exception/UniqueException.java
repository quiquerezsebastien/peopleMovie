/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.exception;

/**
 *
 * @author sebastie.quiquere
 */
public class UniqueException extends Exception{

    public UniqueException() {
    }

    public UniqueException(String message) {
        super(message);
    }
    
}

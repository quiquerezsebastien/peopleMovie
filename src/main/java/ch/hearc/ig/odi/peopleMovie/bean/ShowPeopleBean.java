/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.bean;

import ch.hearc.ig.odi.peopleMovie.business.Person;
import ch.hearc.ig.odi.peopleMovie.service.Services;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "showPeopleBean")
@RequestScoped
public class ShowPeopleBean {
    
    @Inject Services service;
    private List<Person> people;
    /**
     * Creates a new instance of ShowPeopleBean
     */
    public ShowPeopleBean() {
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
    public void initEntities() {
        this.people = service.getPeopleList();
    }

}

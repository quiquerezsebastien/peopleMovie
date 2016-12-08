/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peopleMovie.bean;

import ch.hearc.ig.odi.peopleMovie.business.Person;
import ch.hearc.ig.odi.peopleMovie.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "managePerson")
@RequestScoped
public class ManagePerson {
    
    @Inject Services service;
    int currentPersonID;
    Person currentPerson;

    /**
     * Creates a new instance of ManagePerson
     */
    public ManagePerson() {
    }
    
    public void initPerson() {
        String idParam = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");
        if (!(idParam == null || idParam.isEmpty())) {
            currentPersonID = Integer.parseInt(idParam);
            currentPerson = service.getPersonWithId(new Long(currentPersonID));
        }
    }
    
}

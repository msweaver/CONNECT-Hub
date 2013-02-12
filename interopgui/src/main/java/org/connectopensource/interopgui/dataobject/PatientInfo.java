/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import java.util.Date;

/**
 * @author msw
 *
 */
public class PatientInfo {
    
    public enum Gender { MALE, FEMALE, UNKNOWN }
    
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    

}

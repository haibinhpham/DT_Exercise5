/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inhabitant;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

/**
 *
 * @author ad
 */
//extends unicastremoteobject implements inhabitant
public class InhabitantImp extends UnicastRemoteObject implements Inhabitant {
    //variable declareation: name, dob, bool married
    private static final long serialVersionUID = 1L;
    private String name;
    private String dob;
    private String married;

    //init constructor
    public InhabitantImp(String name, String dob, String married) throws RemoteException {
        super();
        this.name = name;
        this.dob = dob;
        this.married = married;
    }

    //overide get name
    @Override
    public String getName() {
        return name;
    }

    //override get dob
    @Override
    public String getDob() {
        return dob;
    }

    //override ismarried
    @Override
    public String getMarried() {
        return married;
    }

    //override setmarried
    @Override
    public void setMarried(String married) {
        this.married = married;
    }

}

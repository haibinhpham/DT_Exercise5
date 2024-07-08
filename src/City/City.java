/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package City;

import Inhabitant.Inhabitant;
import Inhabitant.InhabitantImp;
import java.rmi.*;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
//extends Remote
public interface City extends Remote {

    //search local throws remote
    //public InhabitantImp searchLocal(String name) throws RemoteException;
    //test
    public Inhabitant searchLocal(String name) throws RemoteException;
    //add local

    public Inhabitant addInhabitant(String name, String dob, String married) throws RemoteException;

    //return name of city
    public String getCityName() throws RemoteException;

    //return list of inhabitants
    public ArrayList<Inhabitant> getListInhabitants() throws RemoteException;

    //search maritial
    public String searchMaritial(String name) throws RemoteException;

    //retrieve list dob
    public ArrayList<String> getAllDob() throws RemoteException;

    //retrieve inhabitant names
    public ArrayList<String> getAllName() throws RemoteException;

    //retrieve list maritial status
    public ArrayList<String> getAllMaritial() throws RemoteException;

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package City;

import Inhabitant.Inhabitant;
import Inhabitant.InhabitantImp;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ad
 */
//extends UnicastRemoteObject implements City
public class CityImp extends UnicastRemoteObject implements City {
    private static final long serialVersionUID = 1L;

    //declare variables, cityname, list<InhabitantImp> listInhabitants
    private String cityName;
    private ArrayList<Inhabitant> listInhabitants;

    //constructor
    public CityImp(String cityName, ArrayList<Inhabitant> listInhabitants) throws RemoteException {
        super();
        this.cityName = cityName;
        this.listInhabitants = listInhabitants;
    }

    //override searchLocal throws remote exception -type InhabitantImp
    @Override
    public Inhabitant searchLocal(String name) throws RemoteException {
        for (Inhabitant local : listInhabitants) {
            if (local.getName().equals(name)) {
                return local;
            }
        }
        return null;
    }

    //override addInhabitant throws remote exception -type InhabitantImp
    @Override
    public Inhabitant addInhabitant(String name, String dob, String married) throws RemoteException {
        Inhabitant local = new InhabitantImp(name, dob, married);
        if (local != null && !listInhabitants.contains(local)) {
            listInhabitants.add(local);
        }
        return null;
    }

    //override getCityName 
    @Override
    public String getCityName() {
        return cityName;
    }

    //override getListInhabitants
    @Override
    public ArrayList<Inhabitant> getListInhabitants() {
        return listInhabitants;
    }

    //override searchMaritial(name)
    @Override
    public String searchMaritial(String name) throws RemoteException {
        for (Inhabitant local : listInhabitants) {
            if (local.getName().equals(name)) {
                return name + "'s maritial status is: " + local.getMarried();
            }
        }
        return "person not found";
    }

    //override getAllDob
    @Override
    public ArrayList<String> getAllDob() throws RemoteException {
        ArrayList<String> listdob = new ArrayList<>();
        for (Inhabitant local : listInhabitants) {
            listdob.add(local.getDob());
        }
        return listdob;
    }
    //override getAllName
    @Override
    public ArrayList<String> getAllName() throws RemoteException{
        ArrayList<String> listname = new ArrayList<>();
        for(Inhabitant local : listInhabitants){
            listname.add(local.getName());
        }
        return listname;
    }
    //override getall status
    @Override
    public ArrayList<String> getAllMaritial() throws RemoteException{
        ArrayList<String> listmarried = new ArrayList<>();
        for(Inhabitant local : listInhabitants){
            listmarried.add(local.getMarried());
        }
        return listmarried;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;
//import rmi registry
//import rmi

import City.CityImp;
import Inhabitant.Inhabitant;
import Inhabitant.InhabitantImp;
import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author ad
 */
public class Server {
    //declare list cities
    public static void main(String[] args) {
        try {
            //init listcities
            ArrayList<CityImp> listCities = new ArrayList<>();
            //create 2 list inhabitants, fra, zur
            ArrayList<Inhabitant> listfra = new ArrayList<>();
            ArrayList<Inhabitant> listzur = new ArrayList<>();
            //create 2 person per city
            InhabitantImp john = new InhabitantImp("john", "11111", "married");
            InhabitantImp mary = new InhabitantImp("mary", "22222", "not married");
            InhabitantImp mark = new InhabitantImp("mark", "33333", "married");
            InhabitantImp silvie = new InhabitantImp("silvie", "44444", "married");
            //add into fra, zur
            listfra.add(john);
            listfra.add(mary);
            listzur.add(mark);
            listzur.add(silvie);
            //create 2 cities stub (fra, zur)
            CityImp frankfurt = new CityImp("frankfurt",listfra);
            CityImp zurich = new CityImp("zurick", listzur);
            //add 2 cities into listcities
            listCities.add(frankfurt);
            listCities.add(zurich);
            
            //start registry on cmd (cd to this project directory, run start rmiregis
            //locate the resgitry LocateRegistry.getRegistry("localhost",10000)
            //LocateRegistry.getRegistry("localhost", 10000);
            //sout registry started on which port
            //System.out.println("registry started in cmdline port 10000");
            System.out.println("registry started in cmdline in standard port");
            //bind fra, zur into stubs
            //Naming.rebind("rmi://localhost:10000/frankfurt",frankfurt)
            
            //fra
            Naming.rebind("rmi://localhost/frankfurt", frankfurt);
            
            System.out.println("frankfurt binded to registry");
            //zur
            Naming.rebind("rmi://localhost/zurich", zurich);
            System.out.println("zurich binded to registry");
            //sout binded to registry
            //repeat for zur
      
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}

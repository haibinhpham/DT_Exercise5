/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import City.City;
import Inhabitant.Inhabitant;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ad
 */
public class Client {

    public static void main(String[] args) {
        try {
            //create 2 city stubs to look up -fra, zur
            //note: type city not cityimp
            //ex: City fra = (City) Naming.lookup("rmi://localhost:10000/frankfurt")
            City frankfurt = (City) Naming.lookup("rmi://localhost/frankfurt");
            City zurich = (City) Naming.lookup("rmi://localhost/zurich");
            //create scanner
            Scanner sc = new Scanner(System.in);
            //choose city in cmdline
            //City chosenCity == nul
            City chosenCity = null;
            System.out.println("enter city name: ");
            //sout city name - String cityname = sc.nextline
            String cityName = sc.nextLine();
            //if(cityname.equalseignorecase-frankfurt -> chosencity = frankfurt)- repeat for zurich
            if (cityName.equalsIgnoreCase("frankfurt")) {
                chosenCity = frankfurt;
            } else if (cityName.equalsIgnoreCase("zurich")) {
                chosenCity = zurich;
            } else {
                System.out.println("city does not exist");
            }
            System.out.println("enter method name: ");
            //sout choose method name
            String method = sc.nextLine();
            switch (method) {
                case "searchLocal" -> {
                    System.out.println("enter name to search: ");
                    String searchName = sc.nextLine();
                    Inhabitant local = chosenCity.searchLocal(searchName);
                    if (local != null) {
                        System.out.println("Person name is: " + local.getName());

                    } else {
                        System.out.println("inhabitant not found");
                    }
                }
                case "getCityName" ->
                    System.out.println("city name: " + chosenCity.getCityName());
                case "addInhabitant" -> {
                    System.out.println("enter name: ");
                    String newName = sc.nextLine();
                    System.out.println("enter dob: ");
                    String newDob = sc.nextLine();
                    System.out.println("enter maritial status: ");
                    String newMarried = sc.nextLine();
                    chosenCity.addInhabitant(newName, newDob, newMarried);
                    System.out.println(newName + " added to " + chosenCity.getCityName());
                }
                case "getListInhabitants" -> {
                    @SuppressWarnings("unchecked")
                    ArrayList<Inhabitant> listInhabitant = chosenCity.getListInhabitants();

                    //print everything
                    for (Inhabitant local : listInhabitant) {
                        System.out.println("name: " + local.getName());
                        System.out.println("dob: " + local.getDob());
                        System.out.println("m.status: " + local.getMarried());
                    }
                }
                case "getAllDob" -> {
                    ArrayList<String> listdob = chosenCity.getAllDob();
                    for (String dob : listdob) {
                        System.out.println("dob: " + dob);
                    }
                }
                case "getAllName" -> {
                    ArrayList<String> listname = chosenCity.getAllName();
                    for (String name : listname) {
                        System.out.println("name: " + name);
                    }
                }
                case "getAllMaritial" -> {
                    ArrayList<String> listmarried = chosenCity.getAllMaritial();
                    for (String married : listmarried) {
                        System.out.println("m.status: " + married);
                    }
                }
                case "setMarried" -> {
                    System.out.println("enter name:");
                    String tempName = sc.nextLine();
                    Inhabitant tempLocal = chosenCity.searchLocal(tempName);
                    if (tempLocal != null) {
                        System.out.println("local exists: " + tempLocal.getName());
                        System.out.println("enter new status: ");
                        String tempMarried = sc.nextLine();
                        tempLocal.setMarried(tempMarried);
                        System.out.println(tempLocal.getName() + "'s new status is: " + tempLocal.getMarried());
                    } else {
                        System.out.println("local does not exist");
                    }

                }
                case "getName" -> {
                    System.out.println("enter name: ");
                    String arbitrary = sc.nextLine();
                    Inhabitant arbitraryLocal = chosenCity.searchLocal(arbitrary);
                    if (arbitraryLocal != null) {
                        System.out.println("Person name is: " + arbitraryLocal.getName());

                    } else {
                        System.out.println("inhabitant not found");
                    }
                }
                case "getMarried" -> {
                    System.out.println("enter name: ");
                    String arbitrary2 = sc.nextLine();
                    Inhabitant arbitrary2Local = chosenCity.searchLocal(arbitrary2);
                    if (arbitrary2Local != null) {
                        System.out.println(arbitrary2Local.getName() + "'s status is: " + arbitrary2Local.getMarried());
                    } else {
                        System.out.println("person does not exist");
                    }
                }
                case "getDob" -> {
                    System.out.println("enter name: ");
                    String arbitrary3 = sc.nextLine();
                    Inhabitant arbitrary3Local = chosenCity.searchLocal(arbitrary3);
                    if (arbitrary3Local != null) {
                        System.out.println(arbitrary3Local.getName() + "'s dob is: " + arbitrary3Local.getDob());
                    }
                }
                default ->
                    System.out.println("invalid parameters");
            }

            sc.close();
            //switch method
            //case addLocal: scan the variables, invoke chosencity.addLocal, sout the results
            //case searchmaritial: scan the name, sout(chosencity.searchmaritial(name))
            //case getalldob: (string) listdob = chosencity.getalldob(), iterate over array and print
            //case getallname: same as above

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

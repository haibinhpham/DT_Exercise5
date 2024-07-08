/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inhabitant;
import java.rmi.*;
/**
 *
 * @author ad
 */
//extends remote
public interface Inhabitant extends Remote{
    //get name throws remote ex
     public String getName() throws RemoteException;
     //get dob throws remote ex
     public String getDob() throws RemoteException;
    //is married throws remote ex
    public String getMarried() throws RemoteException;
    //set married throws remote ex
    public void setMarried(String married) throws RemoteException;
    
}

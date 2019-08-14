/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package package_1;

/**
 *
 * @author hp
 */
class Employee {
    
    int id,aadhar;
    String name,mobile,service,status,address;
    
    Employee(int id,int aadhar,String name,String mobile,String service,String address,String status){
        this.id=id;
        this.aadhar=aadhar;
        this.name=name;
        this.mobile=mobile;
        this.address=address;
        this.service=service;
        this.status=status;
    }
}

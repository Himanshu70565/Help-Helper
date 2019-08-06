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
class User {
 public String customer_id,service,address,status;
 int service_id;
 
 public User(String customer_id,String service,String address,String status,int service_id){
     this.customer_id=customer_id;
     this.service=service;
     this.address=address;
     this.status=status;
     this.service_id=service_id;
 }
}

/**
 * 
 */
package com.signify.bean;
import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * @author ALRAHIMA
 *
 */
@Component
public class Payment {
	//Payment Variables
	private int Studentid;
	private int total_payment;
	private String Mode_of_payment;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStudentid() {
		return Studentid;
	}
	public void setStudentid(int studentid) {
		Studentid = studentid;
	}
	public int getTotal_payment() {
		return total_payment;
	}
	public void setTotal_payment(int total_payment) {
		this.total_payment = total_payment;
	}
	public String getMode_of_payment() {
		return Mode_of_payment;
	}
	public void setMode_of_payment(String mode_of_payment) {
		Mode_of_payment = mode_of_payment;
	}
	
	
    

}

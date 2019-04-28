package chose;

//import java.io.IOException;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import chose.Customer;
@WebServlet("/Customer")
public class Customer {
	      private String name;
	     private String address;
	     private String cardType;
	     private String card;

	      public String getName() {
	         return name;
	     }

	     public void setName(String name) {
	         this.name = name;
	     }

	     public String getAddress() {
	         return address;
	     }

	     public void setAddress(String address) {
	         this.address = address;
	     }

	     public String getCardType() {
	         return cardType;
	     }

	     public void setCardType(String cardType) {
	         this.cardType = cardType;
	     }
	
	     public void setCard(String card) {
	        this.card = card;
	     }
	     public String getCard() {
	         return card;
	     }
 
	     public Customer(String name, String address, String cardType, String card) {
	         super();
	         this.name = name;
	         this.address = address;
	         this.cardType = cardType;
	         this.card = card;
	    } 
	     public Customer() {
	         super();
	     }
	 
	 }

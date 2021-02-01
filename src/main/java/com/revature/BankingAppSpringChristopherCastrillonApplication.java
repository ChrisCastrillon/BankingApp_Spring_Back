package com.revature;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.Address;
import com.revature.models.Application;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.AccountRepository;
import com.revature.repositories.ApplicationRepository;
import com.revature.repositories.UserRepository;

@SpringBootApplication
public class BankingAppSpringChristopherCastrillonApplication extends SpringBeanAutowiringSupport {

	
    public static void main(String[] args) {
        //this is used to get spring beans, you cannot get beans in the main method using 
        //"Autowired" because there is not context yet
		ConfigurableApplicationContext context = SpringApplication.run(BankingAppSpringChristopherCastrillonApplication.class, args);
		
		UserRepository userDAO = context.getBean(UserRepository.class);
		ApplicationRepository appDAO = context.getBean(ApplicationRepository.class);
		AccountRepository accountDAO = context.getBean(AccountRepository.class);
		
		
		
		Application testApplication = new Application(0, AccountType.Checking, 100000.00, "Software Engineer", null );
		User testUser1 = new User(0,Role.User,"Christopher", "Castrillon", 111111111, "cc3988", "password", "ccastrillon@bankingApp.com", null, null, testApplication);
		Set<User> testUser1AddressUsersList = new HashSet<>();
		testUser1AddressUsersList.add(testUser1);
		Address testUserAddress = new Address(0, "14 Loraine Street", "Brentwood", "New York", 11717, testUser1AddressUsersList);
		Set<Address> testUser1AddressList = new HashSet<>();
		testUser1AddressList.add(testUserAddress);
		testUser1.setAddresses(testUser1AddressList);
		testApplication.setApplicationOwner(testUser1);
		System.out.println("User data is: " + testUser1.toString());
		userDAO.save(testUser1);
		appDAO.save(testApplication);
		testUser1.setUserId(1);
		Account testAccount = new Account(0, AccountType.Checking, 10000.00,testUser1 );
		accountDAO.save(testAccount);
		System.out.println("ok");
		System.out.println("Annother commit");
    }

}

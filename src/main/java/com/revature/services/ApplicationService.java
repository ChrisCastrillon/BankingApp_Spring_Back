package com.revature.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.AccountType;
import com.revature.models.Application;
import com.revature.models.User;
import com.revature.repositories.ApplicationRepository;
import com.revature.repositories.UserRepository;
import com.revature.templates.ApplicationFormTemplate;

@Service
public class ApplicationService implements IApplicationService {
    private User user;
    private Application app;
    
    @Autowired
    private UserRepository userDAO;
    @Autowired
    private ApplicationRepository appDAO;

    @Override
    public Application applicationFormToApplication(ApplicationFormTemplate appTemplate) {
       this.user = userDAO.findByEmail(appTemplate.getEmail()); 
       this.app = new Application(0, appTemplate.getFirstname(), appTemplate.getLastname(), Integer.valueOf(appTemplate.getSsn()), appTemplate.getSalary(), appTemplate.getJobTitle(), getAccountTypeFromTemplate(appTemplate), appTemplate.getEmail(), user);
       this.appDAO.save(this.app);
       this.user.addApplication(app);
       this.userDAO.save(this.user);
       return this.app;
    }
    public AccountType getAccountTypeFromTemplate(ApplicationFormTemplate appTemplate) {
       if(appTemplate.getAccountType().equals("Checking")) {
            return AccountType.Checking;
        }
       return AccountType.Savings;
    }
    
}

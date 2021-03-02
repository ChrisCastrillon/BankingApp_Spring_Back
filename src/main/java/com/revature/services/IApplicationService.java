package com.revature.services;

import com.revature.models.Application;
import com.revature.templates.ApplicationFormTemplate;

public interface IApplicationService {
    
    public Application applicationFormToApplication(ApplicationFormTemplate appTemplate);

}

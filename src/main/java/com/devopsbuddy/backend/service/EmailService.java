package com.devopsbuddy.backend.service;

import com.devopsbuddy.web.domian.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    /**
     * @param feedbackPojo
     */
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);


    /**
     * @param message
     */
    public void sendGenericEmailMessage(SimpleMailMessage message);
}

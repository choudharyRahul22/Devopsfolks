package com.devopsbuddy.web.controller;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.web.domian.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private EmailService emailService;

    public static final String FEEDBACK_MODEL_KEY = "feedback";
    public static final String CONTACT_US_VIEW_NAME = "contact/contact";

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getContact(Model model) {
        FeedbackPojo feedback = new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedback);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String setContact(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback) {
       LOG.debug("Feedback POJO content : {}",feedback);
       emailService.sendFeedbackEmail(feedback);
       return ContactController.CONTACT_US_VIEW_NAME;
    }
}

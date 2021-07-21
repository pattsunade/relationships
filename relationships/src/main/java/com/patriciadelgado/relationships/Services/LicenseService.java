package com.patriciadelgado.relationships.Services;

import java.util.Optional;

import com.patriciadelgado.relationships.Models.License;
import com.patriciadelgado.relationships.Repositories.LicenseRepository;

import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License createLicense(License license) {
        return licenseRepository.save(license);
    }

    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()){
            return optionalLicense.get();
        } else {
            return null;
        }
    }

    public static License findPerson(Long id) {
        return null;
    }

    

${user.id == evento.host.id}

    
 // @PostMapping("/events")
    // public String createEvent(@Valid @ModelAttribute("event") Event event,
    //         BindingResult result, HttpSession session, Model model) {
    //     if (result.hasErrors()) {
    //         Long hostId = (Long) session.getAttribute("userId");
    //         User host = userService.findUserById(hostId);
            
    //         List<Event> eventIn = eventService.getInState(host.getState());
    //         model.addAttribute("eventIn", eventIn);
    //         List<Event> eventOut = eventService.getOutState(host.getState());
    //         model.addAttribute("eventOut", eventOut);
    //         model.addAttribute("user", host);
    //         return "events.jsp";
    //     } else {
    //         User host = userService.findUserById((Long) session.getAttribute("userId"));
    //          session.getAttribute("userId");
    //          event.setHost(host);
            
    //         eventService.addEvent(event);
    //         return "redirect:/events";

    //     }
     <div class="container text-center mt-5 bg-light p-3 rounded">
		
		<form:form method="POST" action="/events" modelAttribute="event" class="form-group">
			<p>
			    <form:label path="name">Event Name:</form:label>
			    <form:input type="text" path="name" cssClass="form-control"/>
			</p>
			<p>
			    <form:label path="date">Event Date:</form:label>
			    <form:input type="date" path="date" cssClass="form-control"/>
			</p>
			<p>
			    <form:label path="location">Event Location:</form:label>
			    <form:input type="text" path="location" cssClass="form-control"/>
			</p>
            
        </form:form>
		
            </div>
    
}

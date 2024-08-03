package i2i_intern.hw12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import i2i_intern.hw12.model.Subscriber;
import i2i_intern.hw12.repository.SubscriberRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @GetMapping("/subscriber")
    public String showForm(Subscriber subscriber) {
        Subscriber.addAttribute("subscriber", new Subscriber());
        return "subscriber";
    }


    @PostMapping("/subscriber")
    public String submitForm(@ModelAttribute Subscriber subscriber) {
        subscriberRepository.save(subscriber);
        return "redirect:/subscriber";
    }
}

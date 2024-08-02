package i2i_intern.hw13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerr {

    @GetMapping("/voice")
    public String sendVoice(@RequestParam int a, @RequestParam int b, @RequestParam int duration, @RequestParam String location) {
        String message = "A call was made from " + a + " to " + b + " for " + duration + " minutes in " + location + ".";
        System.out.println(message);
        return message;
    }

    @GetMapping("/message")
    public String sendMessage(@RequestParam int a, @RequestParam int b, @RequestParam String location) {
        String message = "A message was sent from " + a + " to " + b + " in " + location + ".";
        System.out.println(message);
        return message;
    }

    @GetMapping("/data")
    public String sendData(@RequestParam int a, @RequestParam int mb, @RequestParam String rg, @RequestParam String location) {
        String message = "Number " + a + " has consumed " + mb + "MB with rating group " + rg + " in " + location + ".";
        System.out.println(message);
        return message;
    }
}

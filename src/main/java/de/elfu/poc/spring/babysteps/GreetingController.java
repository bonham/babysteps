package de.elfu.poc.spring.babysteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @GetMapping("/many")
  public GreetingList many() {

    List<String> namesList = Arrays.asList( "Paula", "Emma", "Ilse");
    ArrayList<Greeting> greetingList = new ArrayList<Greeting>(namesList.size());

    for (String thisName : namesList) {
      Greeting g = new Greeting(counter.incrementAndGet(), String.format(template, thisName));
      greetingList.add(g);
    } 

    return new GreetingList(greetingList);

  }
  
}

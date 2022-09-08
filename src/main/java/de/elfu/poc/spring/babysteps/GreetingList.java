package de.elfu.poc.spring.babysteps;

import java.util.ArrayList;

public class GreetingList {
  private final ArrayList<Greeting> greetingList;

  public GreetingList(ArrayList<Greeting> greetingList) {
    this. greetingList = greetingList;
  }

  public ArrayList<Greeting> getGreetingList() {
    return this.greetingList;
  }
}

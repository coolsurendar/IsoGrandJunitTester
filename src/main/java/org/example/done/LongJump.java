package org.example.done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class LongJump {

  public static void main( String[] argv ) throws Exception {
    String  line;
    Scanner sc = new Scanner(System.in);
    int numberOfTrials= Integer.parseInt(sc.nextLine());
    List< Trial> trials = new ArrayList<>();

    for (int i = 0; i < numberOfTrials; i++) {
      String trial=sc.nextLine();
      String[] splitStr=trial.split("\\s+");
      trials.add(new Trial(splitStr[0],Double.parseDouble(splitStr[1]),splitStr[2]));
    }

    Map<String ,PersonalBest> personalBests = new HashMap<>();

    for(Trial trial:trials){
      if(personalBests.containsKey(trial.name)){
         PersonalBest personalBest=personalBests.get(trial.name);
        if("S".equals(trial.result)){
          personalBests.put(trial.name, new  PersonalBest(trial.name,trial.height,1,personalBest.getTotalFailures()));
        }else{
          personalBests.put(trial.name, new  PersonalBest(trial.name,personalBest.getBestHeight(),personalBest.getAttempts(),personalBest.getTotalFailures()+1));
        }

      }else{
        if("S".equals(trial.result)){
          personalBests.put(trial.name, new  PersonalBest(trial.name,trial.height,1,0));
        }else{
          personalBests.put(trial.name, new  PersonalBest(trial.name,0,1,1));
        }

      }
    }

    // Populate the map with PersonalBest objects...

    List<Map.Entry<String,  PersonalBest>> entryList = new ArrayList<>(personalBests.entrySet());

    // Create a custom Comparator that sorts by bestHeight, attempts, and totalFailures
    Comparator<Entry<String,  PersonalBest>> personalBestComparator = (entry1, entry2) -> {
       PersonalBest pb1 = entry1.getValue();
       PersonalBest pb2 = entry2.getValue();

      int result = Double.compare(pb2.getBestHeight(), pb1.getBestHeight()); // Sort by bestHeight in descending order

      if (result == 0) { // If bestHeight is the same, sort by attempts in ascending order
        result = Integer.compare(pb1.getAttempts(), pb2.getAttempts());
      }

      if (result == 0) { // If attempts are also the same, sort by totalFailures in ascending order
        result = Integer.compare(pb1.getTotalFailures(), pb2.getTotalFailures());
      }

      return result;
    };

    // Sort the entryList using the custom Comparator
    Collections.sort(entryList, personalBestComparator);

    if(entryList.get(0).getValue().equals(entryList.get(1).getValue()))
    {
      System.out.println("KO");
    }else {
      System.out.println(entryList.get(0).getValue().name);
    }

    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
  }

  record Trial(String name,double height,String result){};
}

class PersonalBest{
  String name;
  double bestHeight;
  int attempts;
  int totalFailures;

  public PersonalBest(String name, double bestHeight, int attempts, int totalFailures) {
    this.name = name;
    this.bestHeight = bestHeight;
    this.attempts = attempts;
    this.totalFailures = totalFailures;
  }


  public String getName() {
    return name;
  }


  public double getBestHeight() {
    return bestHeight;
  }


  public int getAttempts() {
    return attempts;
  }


  public int getTotalFailures() {
    return totalFailures;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

     PersonalBest that = ( PersonalBest) o;

    if (Double.compare(that.bestHeight, bestHeight) != 0) {
      return false;
    }
    if (attempts != that.attempts) {
      return false;
    }
    return totalFailures == that.totalFailures;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(bestHeight);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + attempts;
    result = 31 * result + totalFailures;
    return result;
  }
}

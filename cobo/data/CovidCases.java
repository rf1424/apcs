import java.io.*;
import java.util.*;

public class CovidCases {
    public static final String country = "Poland";
    ArrayList<Stat> stats = new ArrayList<Stat>();

    public CovidCases() throws Exception{
        Scanner s = new Scanner(new File("CovidData.csv"));

        while (s.hasNext()) {
          Stat nxt = new Stat(s.next());
          stats.add(nxt);
        }
    }

    public String highestIncrease() {
      String date = stats.get(0).date();
      double max = stats.get(0).increase();
      for (Stat s : stats) {
        if (s.increase() > max) {
          max = s.increase();
          date = s.date();
        }
      }
      return "Highest increase date: "+ date;
    }


    public static void main(String[] args) throws Exception{
      CovidCases c = new CovidCases();

      for (Stat s : c.stats) {
        //System.out.println(s.date());
      }

      System.out.println(c.highestIncrease());
    }

}

class Stat {
    String country;
    String date;
    int confirmed;
    int recovered;
    int deaths;
    int activeCases;
    double deathRate;
    double increase;
    String firstDays;
    int dayXth;
    int populationks;
    String tenCase;
    double cases1000s;

    public double increase() {
      return this.increase;
    }

    public String date() {
      return this.date;
    }

    public Stat(String row) {
        String[] elements = row.split(",");
        country = elements[0];
        date = elements[1];
        confirmed = Integer.parseInt(elements[2]);
        recovered = Integer.parseInt(elements[3]);
        deaths = Integer.parseInt(elements[4]);
        activeCases = Integer.parseInt(elements[5]);
        deathRate = Double.parseDouble(elements[6]);
        increase = Double.parseDouble(elements[7]);
        firstDays = elements[8];
        dayXth = Integer.parseInt(elements[9]);
        populationks = Integer.parseInt(elements[10]);
        tenCase = elements[11];
        cases1000s = Double.parseDouble(elements[12]);
    }
}

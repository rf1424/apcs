
Q/As

Activity 1.
  1.  We use Google classroom, GitHub, the Stuy APCS page, and
      YouTube.
  2.  GitHub privacy policies say that they collect registration
      info (username, password, etc.), payment information, and
      profile information (avatar/bio).
  3.  Delimited means separated. Each entry of a data set can be
      separated and extracted from a list.
  4.  The name of the column (data type may or may not be specified)
      can suggest what type of data will be stored in that column (ex.
      name will be a string).
  5.  Pokemon and Music
  6.  Who is the most popular pokemon character? (its n)
      What was the most popular rock band in the 90s?
  7.  (Reddit) polls, or data that reflects opinions submitted by a large
      group.
  8.  MANY REDDIT POLLS. One advantage of having more data is that    
      the larger data is less swung by outliers.
  9.  With services like Spotify, the songs that some individuals listen
      to can help the site recognize what artists/genres are similar and
      base recommendations to others on that info. So, having more users
      and data can lead to better predictions and suggestions. Not sure
      of benefits outside of the service.
  10. I'm not sure how information is processed but I believe Spotify
      creates networks of users that are similar and artists that are
      frequently listened to together, which help to decide recommendations.
  11. In the case of Spotify, yes, but most other forms (like targeted
      ads) are definitely an invasion of privacy.

Activity 2.
  1.  Call it a "cereal".
  2.  N/A
  3.  public class Cereal
  4.  15, one for each property of a cereal listed in the table.
  5.  Name (String), Type (char), Calories, Protein, Fat, Sodium (all ints),
      Fiber, Carbohydrates, Sugar (all doubles), Potassium, Vitamins, Shelf
      (all ints), Weight, Cups, Rating (all doubles).
  8.  How does the amount of protein in Whey compare to that of Corn Pops?
  9.  Which cereal is ranked the highest? (there are no comparison methods).
  10. Add a method that will compare each variable for two instances of Cereal.

Activity 3.
  1.  The temperature at Atlanta, Hartsfield - Jackson Atlanta International
      Airport, GA is 65.0F.
  2.  Code: KALB
      Display: The temperature at Albany International Airport, NY is 57.0F.
  4.  47
  5.  You can filter stations by longitude.
  6.  NSTU: Pago Pago, AS, Samoa.
  7.  We can use this code to determine the Southmost station in a state.
  8.  It would not require much more code, it would just run both filters
      at once.

Activity 4.
  1.  What day had the highest increase in COVID cases in Poland?
  2.  We had searched the database for statistics on COVID cases across the
      world, and we had used a selected portion of it to compare statistics for
      POLSKA.
  3.  We planned out a Stat class that would organize each row of data into
      an instance, which we could then use to compare data points.
  4.  Our class is called Stat, and it contains an instance variable for each
      column that was in the original data table (ex. number recovered).
  5.  public CovidCases() throws Exception{
        Scanner s = new Scanner(new File("CovidData.csv"));

        while (s.hasNext()) {
          Stat nxt = new Stat(s.next());
          stats.add(nxt);
        }
      }

      the constructor of the CovidCases class will add each new instance
      of Stat into an ArrayList called stats. It takes the next row from
      the file, which is the format that the constructor of Stat accepts.

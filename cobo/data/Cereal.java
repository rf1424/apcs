public class Cereal {
  int calories, protein, fat, sodium, potassium, vitamins, shelf;
  double fiber, carbohydrates, sugar, weight, cups, rating;
  char type;
  String name;

  public Cereal(
  String name,
  char type,
  int calories,
  int protein,
  int fat,
  int sodium,
  double fiber,
  double carbohydrates,
  double sugar,
  int potassium,
  int vitamins,
  int shelf,
  double weight,
  double cups,
  double rating
  ) {
    this.name = name;
    this.type = type;
    this.calories = calories;
    this.protein = protein;
    this.fat = fat;
    this.sodium = sodium;
    this.fiber = fiber;
    this.carbohydrates = carbohydrates;
    this.sugar = sugar;
    this.potassium = potassium;
    this.vitamins = vitamins;
    this.shelf = shelf;
    this.weight = weight;
    this.cups = cups;
    this.rating = rating;
  } //omg

  public String name() {
    return name;
  }

  public char type() {
    return type;
  }

  public int calories() {
    return calories;
  }

  public int protein() {
    return protein;
  }

  public int fat() {
    return fat;
  }

  public int sodium() {
    return sodium;
  }

  public double fiber() {
    return fiber;
  }

  public double carbohydrates() {
    return carbohydrates;
  }

  public double sugar() {
    return sugar;
  }

  public int potassium() {
    return potassium;
  }

  public int vitamins() {
    return vitamins;
  }

  public int shelf() {
    return shelf;
  }

  public double weight() {
    return weight;
  }

  public double cups() {
    return cups;
  }

  public double rating() {
    return rating;
  }

  public String toString() {
    String ret = "~~~~~~~ ";
    ret += name;
    ret += " ~~~~~~~\n";
    ret += "\nType: " + type;
    ret += "\nCalories: " + calories;
    ret += "\nProtein: " + protein;
    ret += "\nFat: " + fat;
    ret += "\nSodium: " + sodium;
    ret += "\nFiber: " + fiber;
    ret += "\nCarbohydrates: " + carbohydrates;
    ret += "\nSugar: " + sugar;
    ret += "\nPotassium: " + potassium;
    ret += "\nVitamins: " + vitamins;
    ret += "\nShelf: " + shelf;
    ret += "\nWeight: " + weight;
    ret += "\nCups: " + cups;
    ret += "\nRating: " + rating;
    return ret;
  }

  public static void main(String[] args) {
    Cereal cornPops = new Cereal("Corn Pops", 'C', 110, 1, 0, 90, 1, 13, 12, 20, 25, 2, 1, 1, 35.782791);
    System.out.println(cornPops);
    System.out.println(cornPops.name());
    System.out.println(cornPops.carbohydrates());


    Cereal whey = new Cereal("Whey", 'C', 120, 40, 0, 10, 1.0, 0.0, 0.0, 100, 10, 2, 0.125, 0.25, 100.0);
    System.out.println(whey);
    System.out.println(whey.protein());
  }
}

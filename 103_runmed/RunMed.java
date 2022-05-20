//Rin-Sensei: Julia Kozak, John Gupta-She, Rin Fukuoka
//APCS pd08
//HW103
//2022-05-19
//time spent: 0.5 hrs


public class RunMed {
  private ALHeapMax lilVals;
  private ALHeapMin bigVals;

  //constructor
  public RunMed() {
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin();
  }

  //getMedian() returns median or throws NoSuchElementException()
  public double getMedian() {
    if (lilVals.size() == bigVals.size()) {
      //System.out.println("same!");
      return (lilVals.peekMax() + bigVals.peekMin()) * 0.5;
    }
    if (lilVals.size() > bigVals.size()) {
      //System.out.println("notsame!");
      return lilVals.peekMax();
    }
    else { //lilVals.size() < bigVals.size()
      //System.out.println("notsame!");
      return bigVals.peekMin();
    }
  }

  //helper
  public void balance() {
    if (lilVals.size() > bigVals.size()+1) {
          bigVals.add(lilVals.removeMax());
        }
    if (bigVals.size() > lilVals.size()+1) {
        lilVals.add(bigVals.removeMin());
    }
  }

  //add(Integer newVal) adds newVal to appropriate heap, balances if necessary
  public void add(Integer newVal) {
    if (bigVals.isEmpty()){
      lilVals.add(newVal);
    }
    else {
      if (newVal > lilVals.peekMax()) {
        bigVals.add(newVal);
      } else {
        lilVals.add(newVal);
      }
    }

    balance();
  }

}//end of class

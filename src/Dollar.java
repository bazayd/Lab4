/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 2
 *
 * Purpose: Creates object of Dollar, that is used in Currency and currency array as a type of currency
 * that can be added and subtracted.
 *
 */
public class Dollar extends Currency{

    private String currencyName;

    //default constructor
    public Dollar() {
        super();
        this.currencyName = "Dollar";
    }

    //constructor that takes in a value
    public Dollar(double value) {
        super(value);
        this.currencyName = "Dollar";
    }

    //constructor that takes in a dollar object
    public Dollar(Dollar dollar) {
        super(dollar);
        this.currencyName = dollar.currencyName;
    }

    /*
     * Method that gets the name of currency
     *
     * pre:
     * No argument taken
     *
     * post:
     *      return: String (name of currency)
     *
     *@Override object from extended class Currency
     * return name of currency, "Dollar"
     */
    @Override
    public String getCurencyName() {
        return currencyName;
    }
}
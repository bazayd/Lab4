import java.lang.Math;

/*
 * Authors: Nicholas Kang, Brandon Arriaga
 * Group 10 JAVA
 *
 * Lab 2
 *
 * Purpose: Creates currency object, checks for invalid currency inputs, adds and subtracts currencies,
 * checks for correct currency use and returns currency statement.
 *
 */

public abstract class Currency {
    private int whole;

    private int fraction;

    // Default Construction
    /*
     *  two integer attributes:
     *  whole number -> currency note value
     *  fraction -> currency coin value
     */
    public Currency() {
        this.whole = 0;
        this.fraction = 0;
    }

    // Construction based on double
    /*
     * value cannot be less than 0
     */
    public Currency(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Currency value can't be negative.");
        }

        this.whole = (int) value;
        this.fraction = (int) (Math.round(((value - whole)*100.0)));
        //System.out.println("this frac: " + this.fraction + " f" + Math.round(((value - whole)*100.0)));
    }

    // Copy constructor with input as type Currency
    public Currency(Currency other) {
        this.whole = other.whole;
        this.fraction = other.fraction;
    }

    public abstract String getCurencyName();

    /*
     *Getter for inputted whole value
     *
     * Pre: get whole number from user input
     *
     * post:
     *  return: whole integer
     *
     */
    public int getWhole() {
        return whole;
    }

    /*
     *Getter for inputted fractional value
     *
     * Pre: get fraction number from user input
     *
     * post:
     *  return: fraction integer
     *
     */
    public int getFraction() {
        return fraction;
    }

    /*
     *Setter that sets the value for whole currency numbers
     *
     *Pre: integer whole number
     *
     * Post:
     *  set inputted whole number from getter
     *
     *
     */
    public void setWhole(int whole) {
        if (whole < 0) {
            throw new IllegalArgumentException("Whole part can't be a negative number.");
        }

        this.whole = whole;
    }

    /*
     *Setter that sets the value for fractional currency numbers
     *
     *Pre: integer fraction number
     *
     * Post:
     *  set inputted fractional number from getter
     *
     *
     */
    public void setFraction(int fraction) {
        if (fraction < 0) {
            throw new IllegalArgumentException("Fraction part can't be a negative number.");
        }

        this.fraction = fraction;
    }


    /*
    Method that adds a currency to the array depending on type of currency
    Pre: currency type (Dollar or Pound)
    Post:
        the result of adding input object of same currency


    integer totalWhole = inputted whole number + current whole currency array value
    integer totalFraction = inputted fraction number + current currency fraction array value
    this.whole = total whole value + (fraction total value divided by 100)
    this.fraction = total fraction value mod 100



     */
    public void add(Currency currency) {

        int totalWhole = this.whole + currency.whole;
        int totalFraction = this.fraction + currency.fraction;
        this.whole = totalWhole + (totalFraction / 100);
        this.fraction = totalFraction % 100;

    }

    /*
     *  Method that subtracts a currency to the array depending on type of currency
    Pre:
    	currency type (Dollar or Pound)
    Post:
		the result of subtracting input object of same currency

	*
	* integer totalWhole = inputted whole number * 100 + inputted fraction number
	* integer subtractWholePart = current whole currency amount * 100 + current fraction amount
	* if (total whole number is less than number to subtract by (subtractWholePart))
	*   illegal argument exception thrown
	*
	* integer result = total whole number inputted - subtract whole part
	* this.whole = result value divided by 100
	* this.fraction = result mod 100
	*
     */
    public void subtract(Currency currency) {

        int totalWhole = this.whole * 100 + this.fraction;
        int subtractWholePart = currency.whole * 100 + currency.fraction;
        if (totalWhole < subtractWholePart) {
            throw new IllegalArgumentException("Cannot subtract a larger currency value from a smaller one.");
        }
        int result = totalWhole - subtractWholePart;
        this.whole = result / 100;
        this.fraction = result % 100;
    }


    /*
     * Method that compares input object of same currency for equality
    Pre:
    Post:
        return true or false


    *returns boolean that determines if whole currency number from Currency class is equal to user inputted currency and likewise for fraction numbers.
    *
    *
    * returns a true or false value based on comparisons of two values of the same currency
    * return true if this.whole is equal to currency.whole
    * AND return true if this.fraction equals currency.fraction otherwise false.
     */
    public boolean isEqual(Currency currency) {
        return this.whole == currency.whole && this.fraction == currency.fraction;
    }

    /*
     * Method that compares input object of same currency to find out which object is greater/smaller
     *
     * pre:
     * currency type (Dollar or Pound)
     *
     * post:
     * boolean result of whether the input object is greater or not
     *
     *
     * if (currencies are of different classes)
     *     throw illegalArgumentException that states you cannot compare two different currency types
     * totalWhole integer = inputted whole * 100 + inputted fraction
     * compareWhole integer = current currency whole * 100 + current currency fraction
     * compare totalWhole > compareWhole and see if its true or false
     */
    public boolean isGreater(Currency currency) {
        if (!this.getClass().equals(currency.getClass())) {
            throw new IllegalArgumentException("Cannot compare currencies of different types.");
        }
        int totalWhole = this.whole * 100 + this.fraction;
        int compareWhole = currency.whole * 100 + currency.fraction;
        return totalWhole > compareWhole;
    }

    /*
     * Method that stringifies a name and value of a currency object
     *
     * pre:
     * currency type (Dollar or Pound)
     *
     * post:
     * a string that displays the name and value
     *
     * return String.format(whole number.fraction number, the name of the currency(Dollar or Pound)
     */
    public String toString() {
        return String.format("%d.%02d %s", whole, fraction, getCurencyName());
    }
}
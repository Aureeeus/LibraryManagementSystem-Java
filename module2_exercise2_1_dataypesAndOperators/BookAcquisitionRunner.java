package module2_exercise2_1_dataypesAndOperators;

/*
 * Librado, John David R.
 * ITE012 - CS12S1
 * February 26, 2025
 * Application of Data Types, and Operators
 */

public class BookAcquisitionRunner {
  // Declaring instance variables.
  public byte bookQuantity;

  /**
   * BookAcquisitionRunner class contructor.
   * Instantiates attributes to the bookacquisitionrunner instance.
   * 
   * @param bookQuantity : byte(required), quantity of the book.
   */
  public BookAcquisitionRunner(byte bookQuantity) {
    this.bookQuantity = bookQuantity;
  }

  /**
   * Calculate's the discount of the order.
   * With 50% being the highest possible discount.
   * 
   * @return float: the discounted price (if any).
   */
  public float getPercentageDiscount() {
    // Evaluate percentage of discount based on quantity.
    float percentageDiscount = (this.bookQuantity >= 4) ? 0.25F : 0.00F;
    percentageDiscount = (this.bookQuantity >= 6) ? 0.5F : percentageDiscount;

    return percentageDiscount;
  }

  /**
   * Get additional discount (if applicable).
   * 
   * @param book  : Book(required), a book object.
   * @param books : Book[](required), a book array to iterate.
   * @return float: additional discount (if any).
   * @throws NullPointerException error if book is null.
   */
  public static float getAdditionalDiscount(Book book, Book[] books) {
    // Initializing integral variables.
    float additionalDiscount = 0.00F;
    Book book1 = book;
    // Iterate through an array of books.
    for (Book b : books) {
      Book book2 = b;

      // Stop comparing if it's the same book that we are referring to.
      if (book1.bookId == book2.bookId)
        continue;
      // If not, then let's check possible additional discount.
      String bookTitle1 = book1.bookTitle;
      String bookTitle2 = book2.bookTitle;
      String bookAuthorName1 = book1.getAuthorName();
      String bookAuthorName2 = book2.getAuthorName();
      char bookCategory1 = book1.bookCategory;
      char bookCategory2 = book2.bookCategory;

      // Check if it's the same to yield an additional discount.
      if (bookAuthorName1.equals(bookAuthorName2)) {
        if (bookCategory1 == bookCategory2 && !bookTitle1.equals(bookTitle2)) {
          additionalDiscount = 0.2F;
          break;
        } else if (bookTitle1.equals(bookTitle2)) {
          additionalDiscount = 0.1F;
        } else {
          continue;
        }
      }
    }
    return additionalDiscount;
  }
}
package module2_exercise2_1_dataypesAndOperators;

public class Book extends Author {
  // Declaring instance variables.
  public short bookId;
  public String bookTitle;
  public double bookPrice;
  public char bookCategory;

  /**
   * Book class constructor.
   * Instantiates attributes to the supplier instance.
   * 
   * @param authorLastName  : String(required), last name of the author.
   * @param authorFirstName : String(required), first name of the author.
   * @param bookId          : short(required), id of the book.
   * @param bookTitle       : String(required), title of the book.
   * @param bookPrice       : double(required), price of the book.
   * @param bookCategory    : char(required), category of the book.\
   */
  public Book(String authorLastName, String authorFirstName, short bookId, String bookTitle, double bookPrice,
      char bookCategory) {
    super(authorLastName, authorFirstName);
    this.bookId = bookId;
    this.bookTitle = bookTitle;
    this.bookPrice = bookPrice;
    this.bookCategory = bookCategory;
  }

  /**
   * Get the book's author full name.
   * 
   * @return String: the author's full name.
   */
  public String getAuthorName() {
    return this.bookAuthorFirstname + " " + this.bookAuthorLastname;
  }
}

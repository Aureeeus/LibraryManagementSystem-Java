package module2_exercise2_1_dataypesAndOperators;

public class Author {
  // Declaring instance variables.
  protected String bookAuthorLastname;
  protected String bookAuthorFirstname;

  /**
   * Author class constructor.
   * Instantiates attributes the the author instance.
   * 
   * @param lastName  : String(required), last name of the author.
   * @param firstName : String(required), first name of the author.
   */
  public Author(String lastName, String firstName) {
    this.bookAuthorLastname = lastName;
    this.bookAuthorFirstname = firstName;
  }
}

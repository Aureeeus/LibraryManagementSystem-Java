package module2_exercise2_1_dataypesAndOperators;

public class Supplier {
  // Declaring instance variables.
  private int supplierId;
  private String supplierName;
  private String supplierAddress;
  private long supplierTelephoneNumber;

  /**
   * Supplier class constructor. Instantiates attributes
   * to the supplier instance.
   * 
   * @param supplierId              : int(required), id of the supplier.
   * @param supplierName            : String(required), name of the supplier.
   * @param supplierAddress         : String(required), address of the supplier.
   * @param supplierTelephoneNumber : long(required), telephone's number of the
   *                                supplier.
   */
  public Supplier(int supplierId, String supplierName, String supplierAddress, long supplierTelephoneNumber) {
    this.supplierId = supplierId;
    this.supplierName = supplierName;
    this.supplierAddress = supplierAddress;
    this.supplierTelephoneNumber = supplierTelephoneNumber;
  }

  /**
   * Get's the supplier's id.
   * 
   * @return int: the supplier's id.
   */
  public int getSupplierId() {
    return this.supplierId;
  }

  /**
   * Set's the supplier's id.
   * 
   * @param supplierId : int(required), id for the supplier.
   */
  public void setSupplierId(int supplierId) {
    this.supplierId = supplierId;
  }

  /**
   * Get's the supplier's name.
   * 
   * @return String: the supplier's name.
   */
  public String getSupplierName() {
    return this.supplierName;
  }

  /**
   * Set's the supplier's name.
   * 
   * @param supplierName : String(required), name for the supplier.
   */
  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  /**
   * Get's the supplier's address.
   * 
   * @return String: address of the supplier.
   */
  public String getSupplierAddress() {
    return this.supplierAddress;
  }

  /**
   * Set's the supplier's address.
   * 
   * @param supplierAddress : String(required), address for the supplier.
   */
  public void setSupplierAddress(String supplierAddress) {
    this.supplierAddress = supplierAddress;
  }

  /**
   * Get's the supplier's telephone number.
   * 
   * @return long: the supplier's telephone number.
   */
  public long getSupplierTelephoneNumber() {
    return this.supplierTelephoneNumber;
  }

  /**
   * Set's the supplier's telephone number.
   * 
   * @param supplierTelephoneNumber : long(required), telephone number of the
   *                                supplier.
   */
  public void setSupplierTelephoneNumber(long supplierTelephoneNumber) {
    this.supplierTelephoneNumber = supplierTelephoneNumber;
  }
}

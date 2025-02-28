import module2_exercise2_1_dataypesAndOperators.*;

import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
  // Declaring and initializing essential variables.
  public static HashMap<Book, Supplier> orders = new HashMap<>();
  public static ArrayList<Book> books = new ArrayList<>();

  public static float discountedBookPrice;
  public static boolean orderBook = false;
  public static float totalPrice;

  public static void main(String[] args) {
    // Main GUI
    JFrame frame = new JFrame("Book Transaction System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 800);

    // Create three panels for user navigation.
    JPanel navigator = new JPanel();
    navigator.setLayout(new BoxLayout(navigator, BoxLayout.Y_AXIS));
    JButton viewOrderButton = new JButton("View Order");
    JButton orderBookButton = new JButton("Order Book");
    JButton exitButton = new JButton("Exit");
    viewOrderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    orderBookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    navigator.setBorder(BorderFactory.createEmptyBorder(320, 200, 320, 200));

    navigator.add(viewOrderButton);
    navigator.add(Box.createRigidArea(new Dimension(0, 10)));
    navigator.add(orderBookButton);
    navigator.add(Box.createRigidArea(new Dimension(0, 10)));
    navigator.add(exitButton);
    navigator.add(Box.createRigidArea(new Dimension(0, 10)));

    // Event handlers.
    orderBookButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        orderBook = true;
        while (orderBook) {
          // Create panel for displaying inputs.
          JPanel inputPanel = new JPanel();
          inputPanel.setLayout(new GridLayout(9, 2, 10, 10));
          // Create labels and text fields.
          JLabel bookTitleLabel = new JLabel("Book's Title:");
          JTextField titleField = new JTextField(15);
          JLabel bookAuthorNameLabel = new JLabel("Author's Name:");
          JTextField authorNameField = new JTextField(15);
          JLabel bookIdLabel = new JLabel("Book's ID:");
          JTextField bookIdField = new JTextField(15);
          JLabel bookCategoryLabel = new JLabel("Book's Category:");
          JTextField categoryField = new JTextField(15);
          JLabel bookPriceLabel = new JLabel("Book's Price:");
          JTextField priceField = new JTextField(15);
          JLabel supplierNameLabel = new JLabel("Supplier's Name:");
          JTextField supplierNameField = new JTextField(15);
          JLabel supplierAddressLabel = new JLabel("Supplier's Address:");
          JTextField addressField = new JTextField(15);
          JLabel supplierContactLabel = new JLabel("Supplier's Telephone #:");
          JTextField contactField = new JTextField(15);
          JLabel supplierIdLabel = new JLabel("Supplier's ID:");
          JTextField supplierIdField = new JTextField(15);
          // Add label and text fields.
          inputPanel.add(bookTitleLabel);
          inputPanel.add(titleField);
          inputPanel.add(bookAuthorNameLabel);
          inputPanel.add(authorNameField);
          inputPanel.add(bookIdLabel);
          inputPanel.add(bookIdField);
          inputPanel.add(bookCategoryLabel);
          inputPanel.add(categoryField);
          inputPanel.add(bookPriceLabel);
          inputPanel.add(priceField);
          inputPanel.add(supplierNameLabel);
          inputPanel.add(supplierNameField);
          inputPanel.add(supplierAddressLabel);
          inputPanel.add(addressField);
          inputPanel.add(supplierContactLabel);
          inputPanel.add(contactField);
          inputPanel.add(supplierIdLabel);
          inputPanel.add(supplierIdField);

          // Create custom buttons.
          Object[] options = { "Add Book", "Cancel" };
          // Show inputs.
          int result = JOptionPane.showOptionDialog(
              frame,
              inputPanel,
              "Order Transaction",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.PLAIN_MESSAGE,
              null,
              options,
              options[0]);

          // Handle button press.
          switch (result) {
            case 0: {
              // Storing user inputs.
              String bookTitle = titleField.getText();
              String authorName = authorNameField.getText();
              Short bookId = Short.parseShort(bookIdField.getText());
              char bookCategory = categoryField.getText().toUpperCase().charAt(0);
              double bookPrice = Double.parseDouble(priceField.getText());
              String supplierName = supplierNameField.getText();
              String supplierAddress = addressField.getText();
              long supplierContact = Long.parseLong(contactField.getText());
              int supplierId = Integer.parseInt(supplierIdField.getText());

              // Instantiate book and supplier objects.
              int lastWhitespace = authorName.lastIndexOf(" ");
              String authorLastName = authorName.substring(lastWhitespace + 1);
              String authorFirstName = authorName.substring(0, lastWhitespace);
              Book book = new Book(authorLastName, authorFirstName, bookId, bookTitle, bookPrice, bookCategory);
              Supplier supplier = new Supplier(supplierId, supplierName, supplierAddress, supplierContact);

              // Add objects to dictionary. Good for evaluating quantity instantly.
              orders.put(book, supplier);
              break;
            }
            default: {
              // Stop book order.
              orderBook = false;
              JOptionPane.showMessageDialog(
                  frame,
                  "Thank you for ordering",
                  "Notice!",
                  JOptionPane.INFORMATION_MESSAGE);
            }
          }
        }
        // Adds book price to total price (if price > 0).
        int quantity = orders.size();
        if (quantity > 0 && quantity < 128) {
          BookAcquisitionRunner runner = new BookAcquisitionRunner((byte) quantity);
          float initialDiscount = runner.getPercentageDiscount();

          // Add books to an array.
          orders.forEach((book, supplier) -> {
            books.add(book);
          });
          // Get additional discount.
          Book[] bookArray = books.toArray(new Book[0]);
          orders.forEach((book, supplier) -> {
            float additionalDiscount = BookAcquisitionRunner.getAdditionalDiscount(book, bookArray);
            float totalDiscountPercentage = initialDiscount + additionalDiscount;

            float originalPrice = (float) book.bookPrice;
            float discountedPrice = originalPrice * totalDiscountPercentage;
            float newPrice = originalPrice - discountedPrice;
            book.bookPrice = (double) newPrice;
            // Increment the total discounted book price and total price.
            discountedBookPrice += discountedPrice;
            totalPrice += (float) book.bookPrice;
          });

          // Typecasting book quantity to int and total price to double.
          int bookQuantity = runner.bookQuantity;
          double totalPrice = Main.totalPrice;

          // Initializing essential label and fields for further display.
          JPanel resultPanel = new JPanel();
          resultPanel.setLayout(new GridLayout(4, 2, 10, 10));
          JLabel bookQuantityLabel = new JLabel("Book's Ordered:");
          JTextField bookQuantityField = new JTextField(15);
          JLabel originalPriceLabel = new JLabel("Original Price:");
          JTextField originalPriceField = new JTextField(15);
          JLabel totalPriceLabel = new JLabel("Total Price:");
          JTextField totalPriceField = new JTextField(15);
          JLabel discountedPriceLabel = new JLabel("Discounted Price:");
          JTextField discountedPriceField = new JTextField(15);

          // Adding values to field.
          bookQuantityField.setText(Integer.toString(bookQuantity));
          originalPriceField.setText(Double.toString(totalPrice + discountedBookPrice));
          discountedPriceField.setText(Float.toString(discountedBookPrice));
          totalPriceField.setText(Double.toString(totalPrice));

          // Adding fiels to results panel.
          resultPanel.add(bookQuantityLabel);
          resultPanel.add(bookQuantityField);
          resultPanel.add(originalPriceLabel);
          resultPanel.add(originalPriceField);
          resultPanel.add(discountedPriceLabel);
          resultPanel.add(discountedPriceField);
          resultPanel.add(totalPriceLabel);
          resultPanel.add(totalPriceField);

          // Displaying results.
          Object[] options = { "Exit" };
          int click = JOptionPane.showOptionDialog(
              frame,
              resultPanel,
              "Order Receipt",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.PLAIN_MESSAGE,
              null,
              options,
              options[0]);

          // Exiting transaction.
          if (click < 1) {
            return;
          }
        }
      }
    });
    exitButton.addActionListener(new ActionListener() {
      // Exits the application.
      @Override
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    // Add panel to Main GUI.
    frame.setLayout(new BorderLayout());
    frame.add(navigator, BorderLayout.CENTER);

    // Show GUI
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
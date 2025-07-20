package ui;

import dao.ExpenseDAO;
import model.Expense;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ExpenseDAO dao = new ExpenseDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Expense Tracker Menu ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Get Expense by ID");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.next());
                    System.out.print("Enter category: ");
                    String category = sc.next();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    Expense e = new Expense(0, date, category, amount, description);
                    dao.addExpense(e);
                }

                case 2 -> {
                    List<Expense> expenses = dao.getAllExpense();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        expenses.forEach(System.out::println);
                    }
                }

                case 3 -> {
                    System.out.print("Enter ID to find: ");
                    int id = sc.nextInt();
                    Expense result = dao.getExpenseById(id);
                    if(result != null){
                        System.out.println(result);
                    }
                }

                case 4 -> {
                    Expense e = new Expense();
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    e.setId(id);
                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    e.setDate(LocalDate.parse(sc.next()));
                    System.out.print("Enter new category: ");
                    e.setCategory(sc.next());
                    System.out.print("Enter new amount: ");
                    e.setAmount(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Enter new description: ");
                    e.setDescription(sc.nextLine());
                    dao.updateExpense(e);
                }

                case 5 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteExpense(id);
                }

                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
            System.in.read();
        }
    }
}

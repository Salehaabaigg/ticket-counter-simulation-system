import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TicketCounter {
    private Queue<String> queue;
    private int capacity;

    TicketCounter(int size) {
        capacity = size;
        queue = new LinkedList<>();
    }

    void addPerson(String name) {
        if (queue.size() == capacity) {
            System.out.println("\n Queue is full! Cannot add " + name);
            return;
        }
        queue.add(name);
        System.out.println("\n" + name + " joined the queue.");
    }

    void servePerson() {
        if (queue.isEmpty()) {
            System.out.println("\n No one to serve.");
            return;
        }
        System.out.println("\n " + queue.poll() + " has been served and left the queue.");
    }

    void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("\n Queue is empty.");
            return;
        }
        System.out.println("\n Current Queue:");
        int i = 1;
        for (String person : queue)
            System.out.println(i++ + ". " + person);
    }

    void viewNextPerson() {
        if (queue.isEmpty()) {
            System.out.println("\n No one in queue.");
            return;
        }
        System.out.println("\n Next to be served: " + queue.peek());
    }

    void countPeople() {
        System.out.println("\n Total people in queue: " + queue.size());
    }

    void searchPerson(String name) {
        if (queue.contains(name))
            System.out.println("\n " + name + " is waiting in the queue.");
        else
            System.out.println("\n " + name + " not found in the queue.");
    }

    void removePerson(String name) {
        if (queue.remove(name))
            System.out.println("\n " + name + " has left the queue before being served.");
        else
            System.out.println("\n " + name + " not found in the queue.");
    }

    void checkStatus() {
        if (queue.isEmpty())
         System.out.println("\n Queue is empty.");
        else if (queue.size() == capacity)
         System.out.println("\n Queue is full.");
        else
         System.out.println("\n Queue has space left (" + (capacity - queue.size()) + " spots).");
    }
}

public class TicketCounterSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter maximum queue size: ");
        int size = sc.nextInt();
        sc.nextLine();

        TicketCounter counter = new TicketCounter(size);

        boolean running = true;
        while (running) {
            System.out.println("\n==============================");
            System.out.println("  TICKET COUNTER SIMULATION");
            System.out.println("==============================");
            System.out.println("1  Add Person to Queue");
            System.out.println("2  Serve Next Person");
            System.out.println("3  Display Queue");
            System.out.println("4  View Next to be Served");
            System.out.println("5  Count Total People");
            System.out.println("6  Search Person");
            System.out.println("7  Remove Person by Name");
            System.out.println("8  Check Queue Status");
            System.out.println("9  Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    counter.addPerson(sc.nextLine());
                }
                case 2 -> counter.servePerson();
                case 3 -> counter.displayQueue();
                case 4 -> counter.viewNextPerson();
                case 5 -> counter.countPeople();
                case 6 -> {
                    System.out.print("Enter name to search: ");
                    counter.searchPerson(sc.nextLine());
                }
                case 7 -> {
                    System.out.print("Enter name to remove: ");
                    counter.removePerson(sc.nextLine());
                }
                case 8 -> counter.checkStatus();
                case 9 -> {
                    System.out.println("\n Exiting simulation... Goodbye!");
                    running = false;
                }
                default -> System.out.println("\n Invalid choice! Try again.");
            }

            if (running) {
                System.out.println("\nPress ENTER to continue...");
                sc.nextLine(); // Wait before showing menu again
            }
        }
        sc.close();
    }
}
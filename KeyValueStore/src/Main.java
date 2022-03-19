import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * read one input line and apply command to KeyValueStore
     *
     * @param kvs KeyValueStore
     * @param sc user input
     */
    private static boolean readInput(KeyValueStore kvs, Scanner sc) {
        String command = sc.next();
        String key;
        String value;
        // parse command
        switch (command) {
            case "new":
                key = sc.next();
                value = sc.next();
                try {
                    kvs.newElement(key, value);
                    System.out.println("ok");
                } catch (Exception e) {
                    System.out.println("new: " + e.getMessage());
                }
                break;
            case "update":
                key = sc.next();
                value = sc.next();
                try {
                    kvs.update(key, value);
                    System.out.println("ok");
                } catch (Exception e) {
                    System.out.println("update: " + e.getMessage());
                }
                break;
            case "delete":
                key = sc.next();
                try {
                    kvs.delete(key);
                    System.out.println("ok");
                } catch (Exception e) {
                    System.out.println("delete: " + e.getMessage());
                }
                break;
            case "get":
                key = sc.next();
                try {
                    String get = kvs.get(key);
                    System.out.println("ok: " + get);
                } catch (Exception e) {
                    System.out.println("get: " + e.getMessage());
                }
                break;
            case "quit":
                return false;
        }
        return true;
    }

    /**
     * main method
     *
     * @param args not used
     * @throws IOException readInput
     */
    public static void main(String[] args) throws IOException {
        KeyValueStore kvs;
        if (args.length == 0) {
            kvs = new KeyValueStore();
        } else {
            kvs = new KeyValueStore(args[0]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new / update / delete / get / quit:");
        boolean resume = true;
        while (resume) {
            resume = readInput(kvs, sc);
        }
    }
}
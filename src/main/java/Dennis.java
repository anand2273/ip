import java.util.Scanner;

public class Dennis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String logo = "██████╗ ███████╗███╗   ██╗███╗   ██╗██╗███████╗\n"
                    + "██╔══██╗██╔════╝████╗  ██║████╗  ██║██║██╔════╝\n"
                    + "██║  ██║█████╗  ██╔██╗ ██║██╔██╗ ██║██║███████╗\n"
                    + "██║  ██║██╔══╝  ██║╚██╗██║██║╚██╗██║██║╚════██║\n"
                    + "██████╔╝███████╗██║ ╚████║██║ ╚████║██║███████║\n"
                    + "╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚═╝╚══════╝\n";
        String indentation = "_______________________________________\n";
        String message = (indentation
                            + "this is DENNIS. What can I do for you?\n"
                            + indentation);
        System.out.println(logo + message);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println(indentation + "Catch you later!\n" + indentation);
                break;
            } else {
                System.out.println(indentation + input + "\n" + indentation);
            }
        }
        sc.close();
    }
}

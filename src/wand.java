import java.lang.System;
import java.lang.String;
import java.util.Scanner;

public class wand {
    public int size;
    static Core[] core= Core.values();
    static Scanner scanner = new Scanner(System.in);
    public static void choose_wand_size() {
        Execution.clearconsole();
        System.out.println("Now you have to choose your wand, this one would choose you but" +
                " what size would you like ? It has to be beetwen 9 and 40 inches");
        int size = scanner.nextInt();
        do {
            if (size > 40) {
                System.out.println("Your wand is too long, please choose a shorter one");
                size = scanner.nextInt();
            } else if (size < 9) {
                System.out.println("Your wand is too short, please choose a longer one");
                size = scanner.nextInt();
            }

        } while ((size > 40) || (size < 9));
        System.out.println("Perfect your wand is " + size + " inches");}

        public static void choose_core(){
            Execution.clearconsole();
            System.out.println("Now you have to choose the core for your wand");
            System.out.println("(0) Phoenix_feather");
            System.out.println("(1) Dragon_heartstring");
            int core_value = scanner.nextInt();
            System.out.println("Nice you have " + core[core_value] + " in your wand");
        }
    }

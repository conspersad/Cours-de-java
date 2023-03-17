import java.util.Scanner;

public class House {
    public String House[]={"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"};
    static Scanner scanner = new Scanner(System.in);
    public static void your_house() {
        int a = 0, b = 0, c = 0, d = 0;

        Execution.clearconsole();

        System.out.println("Now you have to answer this few questions to help the sorting hat, answer with your heart !");
        System.out.println("What super power would you like to have ?");
        System.out.println("1 : Read minds ");
        System.out.println("2 : Extreme intelligence");
        System.out.println("3 : Extraordinary strength");
        System.out.println("4 : Fly");
        int value = scanner.nextInt();
        switch (value) {
            case 1 -> a++;
            case 2 -> b++;
            case 3 -> c++;
            case 4 -> d++;
            default -> {
                System.out.println("Réponse invalide !");
                return;
            }
        }
        System.out.println("What quality describe you the best");
        System.out.println("1 : Confidente ");
        System.out.println("2 : Smart");
        System.out.println("3 : Worker");
        System.out.println("4 : Brave");
        int value2 = scanner.nextInt();
        switch (value2) {
            case 1 -> a++;
            case 2 -> b++;
            case 3 -> c++;
            case 4 -> d++;
            default -> {
                System.out.println("Réponse invalide !");
                return;
            }
        }
        System.out.println("What classe do you prefer ?");
        System.out.println("1 : Sort ");
        System.out.println("2 : Potions");
        System.out.println("3 : Herbologie");
        System.out.println("4 : Defense against the force of evil");
        int value3 = scanner.nextInt();
        switch (value3) {
            case 1 -> a++;
            case 2 -> b++;
            case 3 -> c++;
            case 4 -> d++;
            default -> {
                System.out.println("Réponse invalide !");
                return;
            }
        }

        System.out.println("What poster do you have in your room?");
        System.out.println("1 : A fat lady ");
        System.out.println("2 : A knight ");
        System.out.println("3 : A unicorne");
        System.out.println("4 : A snake");
        int value4 = scanner.nextInt();
        switch (value4) {
            case 1 -> a++;
            case 2 -> b++;
            case 3 -> c++;
            case 4 -> d++;
            default -> {
                System.out.println("Réponse invalide !");
                return;
            }
        }
        System.out.println("What are your favorite sweets ?");
        System.out.println("1 : Chocolat ");
        System.out.println("2 : Peanut");
        System.out.println("3 : Licorice");
        System.out.println("4 : Pepper");
        int value5 = scanner.nextInt();
        switch (value5) {
            case 1 -> a++;
            case 2 -> b++;
            case 3 -> c++;
            case 4 -> d++;
            default -> {
                System.out.println("Réponse invalide !");
                return;
            }
        }

        int max = a;

        if (b > max) {
            max = b;
            System.out.println("""
                    Your house is Ravenclaw,\s
                    Intensely intelligent, Ravenclaws are also unique and think outside the box.\s
                    This is usually a good thing, unless by 'thinking outside the box' you mean stealing other wizards' stories and erasing their memories, like a certain Ravenclaw called Gilderoy Lockhart.""");
        }

        if (c > max) {
            max = c;
            System.out.println("""
                    Your house is Hufflepuff,
                    Hufflepuff characteristics include a strong sense of justice, loyalty, patience, and a propensity for hard work.
                     Hufflepuffs are also seen as nice, almost to a fault. Hogwarts houses have moved beyond the realm of fiction and into the real worlds""");
        }

        if (d > max) {
            max = d;
            System.out.println("""
                    Your house is Gryffindor,
                    Courage and chivalry are two of the most recognisable qualities when it comes to this house –\s
                    but that doesn't mean that every Gryffindor is always supremely confident and self-assured.
                     Some can be nervous or unsure of themselves and still belong there. Courage doesn't have to involve flashy or daring gestures.""");
        }
        if(max == a){

        System.out.println("""
                Your house is Slytherin, Slytherin are known for being ambitious, cunning, and resourceful.\s
                Slytherins are also sometimes regarded as being evil thanks to the fact that many of the most sinister witches and wizards
                 have been associated with this house.""");}
    }
}

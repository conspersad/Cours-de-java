import java.util.Scanner;
import java.util.*;

public class House {
    static String house[] ={"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"};
    public static int a = 0, b = 0, c = 0, d = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void poserQuestions() {
        int reponse = scanner.nextInt();
       if((4>reponse)|| (reponse)>1) if (reponse == 1) {
           a++;
       } else if (reponse == 2) {
           b++;
       } else if (reponse == 3) {
           c++;
       } else if (reponse == 4) {
           d++;
       } else {
           System.out.println("Your messing with me ! Let's be serious please");
       }}
    public static void questions() {
        System.out.println("Now you have to answer this few questions to help the sorting hat, answer with your heart !");
        System.out.println("What super power would you like to have ? \n1 : Read minds\n2 : Extreme intelligence \n3 : Extraordinary strength\n4 : Fly" );
        poserQuestions();

        System.out.println("What quality describe you the best \n1 : Confidente \n2 : Smart\n3 : Worker\n4 : Brave");
        poserQuestions();

        System.out.println("What classe do you prefer ? \n1 : Sort \n2 : Potions \n3 : Herbologie\n4 : Defense against the force of evil");
        poserQuestions();

        System.out.println("What poster do you have in your room? \n1 : A fat lady  \n2 : A knight  \n3 : A unicorne  \n4 : A snake");
        poserQuestions();

        System.out.println("What are your favorite sweets ?\n1 : Chocolat\n2 : Peanut\n3 : Licorice\n4 : Pepper");
        poserQuestions();
    }

    public static String your_house(){
        questions();
        int max = a;
        String test1 = null;
        if (b > max) {
            max = b;
            System.out.println("Your house is Ravenclaw,\n" +
                    "Intensely intelligent, Ravenclaws are also unique and think outside the box.\n" +
                    "his is usually a good thing, unless by 'thinking outside the box' you mean stealing other wizards' stories and erasing their memories, like a certain Ravenclaw called Gilderoy Lockhart.");
             test1=house[2];
            return test1;
        }

        if (c > max) {
            max = c;test1=house[1];
            System.out.println("Your house is Hufflepuff,\n" +
                    "Hufflepuff characteristics include a strong sense of justice, loyalty, patience, and a propensity for hard work.\n" +
                    "Hufflepuffs are also seen as nice, almost to a fault. Hogwarts houses have moved beyond the realm of fiction and into the real worlds");

        }

        if (d > max) {
            max = d;
            test1=house[0];
            System.out.println("Your house is Gryffindor,\n" +
                    "Courage and chivalry are two of the most recognisable qualities when it comes to this house \n" +
                    "but that doesn't mean that every Gryffindor is always supremely confident and self-assured.\n" +
                    "Some can be nervous or unsure of themselves and still belong there. Courage doesn't have to involve flashy or daring gestures.");

        }
        if(max == a){
            test1=house[3];
        System.out.println("Your house is Slytherin, Slytherin are known for being ambitious, cunning, and resourceful.s\n" +
                "Slytherins are also sometimes regarded as being evil thanks to the fact that many of the most sinister witches and wizards\n" +
                "have been associated with this house.");

           }
        return test1;
    }}

public class Story{
     public int delay;
    public static void slowPrint(String message, int delay) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay); // Ajouter un délai entre chaque caractère
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Ajouter un retour à la ligne à la fin de l'affichage
    }
    public static void printIntro(){
        Execution.clearconsole();
        Execution.printseperator(30);
        System.out.println("Welcome to Poudlard  I don't doubt that this would be the best years of your life ! " + " But before your adventure starts, you have to buy your fournitures !!");
        Execution.printseperator(5);
    }

    public static void Thephilosopherstone_Intro(){
        String message ="It's been a few days since you are in Poudlard now, you have made quite a few friends, and you are doing very well in your first class\n" +
                "You even learn your first speel, it's Wingardium Leviosas\n" +
                "But this morning you wake up and you didn't see your friend Nevile in potion class\n"+
                Execution.wizard.name + ": Do you know what happend to Nevile ? He never miss potion class !\n" +
                "Hermione: Well, i saw him coming back from the toilets yesterdays he looked very scared, it's seems like he saw a ghost !!"+
                Execution.wizard.name + ": I should probably see! \n\n\n"+
                Execution.wizard.name + ": I should probably see! \n\nNevile \n";
                Execution.printseperator(5);
        slowPrint(message, 100);
      String message2 = "...\nAre you here..\nHo my god, WHAT HAPPEND HERE !!!\nNevile: I'm SORRY\nNevile: I'm SORRY\nNevile: I heard weird noise in the toilet yesterday night so i passe again today but\nNevile: I'm  didn't know it was a\nNevile: TROLL !!!\n";
        slowPrint(message2, 100);
    }

    public static void Thephilosopherstone_Outro(){
    }



    }



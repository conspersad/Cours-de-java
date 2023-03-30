public class Story{
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
        Execution.printseperator(30);
    }

    public static void Thephilosopherstone_Intro(){
        String message ="It's been a few months since you are in Poudlard now, you have made quite a few friends, and you are doing very well in your first class !\n" +
                "You even learn your first speel, it's Wingardium Leviosas.\n" +
                "But this morning you wake up and you didn't see your friend Nevile in potion class.\n"+
                Execution.wizard.name + ": Do you know what happend to Nevile ? He never miss potion class !\n" +
                "Hermione: Well, i saw him coming back from the toilets of the donjon yesterdays he looked very scared, it's seems like he saw a ghost!!\n"+
                Execution.wizard.name + ": I should probably see! \n"+
                Execution.wizard.name + ": I should probably see! \n\nNevile ";
                Execution.printseperator(5);
        slowPrint(message, 25);
      String message2 = "...\n"+ Execution.wizard.name +": Are you here..\n"+ Execution.wizard.name +": Ho my god, WHAT HAPPEND HERE !!!\nNevile: I'm SORRY\nNevile: I'm SORRY\nNevile: I heard weird noise in the toilet yesterday night so i passe again today but\nNevile: I'm  didn't know it was a\nNevile: TROLL !!!\nNevile: You have to use Wingardium Leviosa !!!\n ";
        slowPrint(message2, 25);
    }

    public static void Thephilosopherstone_Outro(){
        String message ="Professor mcgonagall : What happen here Nevile "+ Execution.wizard.name +" !\n" +
                "Professor mcgonagall : Hooooo my goddd, is that a troll !\n" +
                Execution.wizard.name  + " and Nevile : It's a long story...\n"+
                "Professor mcgonagall :I can't believe that wizard that young could defeat a troll !! How is that even possible...\n"+
                "Professor mcgonagall : For your bravery i would give 20 points to " + Execution.wizard.house +"!\n"+
                "Professor mcgonagall : But please next time don't play hereos and call a professor !\n"+
                "Nevile: It was a close one ! But what you did was very brave "+ Execution.wizard.name +". Thank you very much !!\n"
                + Execution.wizard.name +"And i would do it again if it was necessary !\n"+
                "That how you and Nevile became befriends";
        slowPrint(message, 25);
    }

    public static void TheChamberOfSecret_Intro(){
        String message ="At the beginning of this new year, something strange happened before the start of the school year at Hogwarts.\n" +
                " As you were packing your suitcase, a house-elf came to introduce you.\n" +
                " He claims to be called Dobby and he announces that terrible dangers threaten the school of Hogwarts and that you must not return there in September.\n"+
                "And recently, many Hogwarts students claim that The Chamber of Secrets would have been reopened !\n"+
                "Professor mcgonagall : I have heard the rumors that are running this time, please students be careful ! Even if we don't know if it's true let me tell you the story\n"+
                "Professor mcgonagall : Salazar Slytherin, one of the four founders of the school, would have created this famous Chamber and would have hidden there a fearsome monster intended to rid the school of those who are not worthy of it, that is to say the wizards born to muggle parents.\n"+
                "Since what professor mcgonagall said you friend Hermione,Ron and Harry seems very worried\n"+
                "On these complicated times you learn a new spell learned with Professor Rogue: Accio!\n"+
                 "One day you find in the toilet a mysterious diary belonging to a man named Tom Riddle. More and more people are disappearing at Hogwarts and in a panic, show you the diary to your friends Hermione, Ron and Harry.\n"+
                "It is written there that the door to the Chamber of Secrets would be in the toilet\n."+
                "You decide to go there the next day armed with the legend sword of Godric Gryffindor, if your house is Gryffindor you could use it to bring down the monster and end this story.\n";
        Execution.printseperator(5);
        slowPrint(message, 25);
    }
    public static void TheChamberOfSecret_Outro(){
        String message ="Few hours later ....\n" +
                "Dumbledore : Thank you for your bravery Harry, Ron, Hermione and"+ Execution.wizard.name +" !\n" +
                "Dumbledore : And thank you for your service to the school.\n"+
                "Dumbledore : You seems fearless and for that I am going to give 10 points to " + Execution.wizard.house +"!\n"+
                "Hermione :  Thank you for sharing the secret diary with us !\n"+
                "Ron : If it's to fight monsters, don't show us anything anymore please !\n"+
                "Harry and Hermione : RON !!!!\n"+
                "Ron : Just saying, at least we won some points for our house\n"+
                "...\n"+
                "In the evening, a big party is organized in the Great Hall where we find Hermione and the other victims among the students, where Dumbledore announces the cancellation of the exam sessions.\n"+
                "This evening couldn't be better, and you keep wonder what adventures you have in store for the following year!\n";
        Execution.printseperator(5);
        slowPrint(message, 25);
    }

    public static void The_prisoner_of_azkaban_Intro(){
        String message ="It's the start of a new year ! \n" +
        "But over the summer television news from the non-magical world announces the escape of a very dangerous prisoner by the name of Sirius Black.\n " +
                "In the Hogwarts Express, you and Nevile are rescued by  Remus Lupin, who produces a patronus as an Azkaban Dementor," +
                "searching for Sirius Black, attacks your compartment.\n" +
                "Dementors are employed by the Ministry of Magic to guard Azkaban, the wizarding prison.\n " +
                "The Expexto Patronum spell is taught to you during Defense Against the Dark Arts classes to get rid of Dementors.\n"+
                "But during the first lesson about Care of Magical Creatures by Hagrid.\nDraco Malfoy provokes a hippogriff and is attacked by the animal.\n He threatens Hagrid with a lawsuit. And later you learn that Hagrid's hippogryph is condemned to beheading.\n" +
                "To save him, you and Hermione go back in time using the Time Turner.\nBut as you try to save the poor beast in the forest a dementor attacks you !\n";
        Execution.printseperator(5);
        slowPrint(message, 25);
    };
    public static void The_prisoner_of_azkaban_Outro(){
        String message ="Hermione : It was a close one ! \n" +
                Execution.wizard.name + " : Thank god we learn that new speel in class, other wise i don't know what would have happend to us ! \n"+
                "Hermione : Your patronus is beautiful ! \n" +
                Execution.wizard.name + " : Thank you ! My mom had the same.\n"+
                Execution.wizard.name + " : But we really got to go,we must prevent the accident with Malfoy from happening again!\n"+
                        "Few moment later ....\n"+
                "Hagrid : Thank you very much girl, I know what you did to save my hippogriff,I am very grateful for it"+
                 "Hagrid : It look like, he like you !!\n" +
                "Hagrid : You girls want to take a rid !\n"+
                "It was one of the best day of your life, an unforgettable memory !";
        Execution.printseperator(5);
        slowPrint(message, 25);
    };
    }



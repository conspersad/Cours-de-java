public class Story{
    Execution myExc= new Execution();
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
        Execution myExc= new Execution();
        myExc.clearconsole();
        myExc.printseperator(30);
        System.out.println("Welcome to Poudlard  I don't doubt that this would be the best years of your life ! " + " But before your adventure starts, you have to buy your fournitures !!");
        myExc.printseperator(30);
    }

    public static void Thephilosopherstone_Intro(){
        Execution myExc= new Execution();
        myExc.clearconsole();
        String message ="It's been a few months since you are in Poudlard now, you have made quite a few friends, and you are doing very well in your first class !\n" +
                "You even learn your first speel, it's Wingardium Leviosas.\n" +
                "But this morning you wake up and you didn't see your friend Nevile in potion class.\n"+
                Execution.wizard.name + ": Do you know what happend to Nevile ? He never miss potion class !\n" +
                "Hermione: Well, i saw him coming back from the toilets of the donjon yesterdays he looked very scared, it's seems like he saw a ghost!!\n"+
                Execution.wizard.name + ": I should probably see! \n"+
                Execution.wizard.name + ": I should probably see! \n\nNevile ";
        myExc.printseperator(5);
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
        Execution myExc= new Execution();
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
        myExc.printseperator(5);
        slowPrint(message, 25);
    }
    public static void TheChamberOfSecret_Outro(){
        Execution myExc= new Execution();
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
        myExc.printseperator(5);
        slowPrint(message, 25);
    }

    public static void The_prisoner_of_azkaban_Intro(){
        Execution myExc= new Execution();
        String message ="It's the start of a new year ! \n" +
        "But over the summer television news from the non-magical world announces the escape of a very dangerous prisoner by the name of Sirius Black.\n " +
                "In the Hogwarts Express, you and Nevile are rescued by  Remus Lupin, who produces a patronus as an Azkaban Dementor," +
                "searching for Sirius Black, attacks your compartment.\n" +
                "Dementors are employed by the Ministry of Magic to guard Azkaban, the wizarding prison.\n " +
                "The Expexto Patronum spell is taught to you during Defense Against the Dark Arts classes to get rid of Dementors.\n"+
                "But during the first lesson about Care of Magical Creatures by Hagrid.\nDraco Malfoy provokes a hippogriff and is attacked by the animal.\n He threatens Hagrid with a lawsuit. And later you learn that Hagrid's hippogryph is condemned to beheading.\n" +
                "To save him, you and Hermione go back in time using the Time Turner.\nBut as you try to save the poor beast in the forest a dementor attacks you !\n";
        myExc.printseperator(5);
        slowPrint(message, 25);
    };
    public static void The_prisoner_of_azkaban_Outro(){
        Execution myExc= new Execution();
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
        myExc.printseperator(5);
        slowPrint(message, 25);
    }
    public static void The_goblet_of_fire_Intro(){
        Execution myExc= new Execution();
        String message ="You and your friends are going back to Hogwarts for the start of the new school year in this fourth year\n." +
                " This new year is marked by the return of the The wizard Tournament, an old tournament which regularly opposed a sorcerer's apprentice from each of the most prestigious schools of witchcraft in Europe\n, " +
                "in other words Hogwarts, Beauxbatons and Durmstrang.\n " +
                "However, this year, in addition to the usual three candidates, the Goblet of Fire chooses a fourth participant: you!\n" +
                " You swear never to have put your name in the Cup, and you are forced to face the three great trials:\n" +
                " stealing a golden egg from a dragon,\n" +
                " swimming underwater for an hour to recover a treasure that is yours dear -in this case your friend Hermione\n" +
                " and grab the trophy hidden in a maze full of dangerous creatures and spells.\n"+
                "Thanks to the help of your friends, you manage to grab the trophy in the maze at the same time as Cedric Diggory during the third and final task.\n"
                +"But the trophy happens to be a Portkey that takes you to the Little Hangleton Cemetery.\n"+
                "There, you discover Peter Pettigrew who kills Cedric, ties you up, and resurrects Voldemort with Harry's blood, the bones of Tom Riddle Senior, and his own flesh.\n"+
                "You have to take the Portkey back to escape, you're not powerful enough to fight!\n"+
                "Use Accio at least three times to pull the Portkey towards you and escape but be careful your ennemies are very powerful !\n";
        myExc.printseperator(5);
        slowPrint(message, 25);
    }
    public static void The_goblet_of_fire_Outro(){
        Execution myExc= new Execution();
        String message ="You use accio to manage to grab the Portkey, annd you escape!\n"+
                "You tell the details of what happened to Dumbledore and Sirius, then you are sent to Madam Pomfrey, the nurse, your friends follow you very worried.\n"+
                "Cornelius Fudge, the Minister of Magic, argues with Dumbledore and refuses to believe that Voldemort has returned. Therefore, he refuses to take the necessary measures.\n+" +
                " The end of the year approaches. During the grand banquet speech, Dumbledore brings up Cedric's death and warns the students against Voldemort's return.\n+" +
                " You give the sum of money won by his victory in the tournament to Fred and George to enable them to finance their shop of tricks and tricks.\n"+
                 "Voldemort is back and Hagrid solemnly declares that it will be necessary to prepare to face him really.\n" +
                "What a year !\n";
        myExc.printseperator(5);
        slowPrint(message, 25);
    }

    public static void The_order_of_the_phoenix_Intro(){
        Execution myExc= new Execution();
        String message ="You spend your holidays in Grimmauld Square with Sirius Black, Hermione, Remus Lupin and the Weasley family at the headquarters of the Order of the Phoenix,\n"+
                "whose members try to awaken the consciences of other wizards and make publicly know about Voldemort's return.\n" +
                "Back at Hogwarts, you and your friends discover that Dolores Umbridge, the Minister's Under-Secretary of State , is the new Defense Against the Dark Arts teacher.\n"+
                "In class, the latter refuses to let the students practice magic, and makes you study only the theory by reading the manuals, which revolts everyone.\n"+
                "You receive many hours of detention from Umbridge for her insubordination, and especially when you insist on Voldemort's return.\n"+
                "Umbridge finds a way to control the school and Dumbledore's authority by enacting Education Decrees. You are fed up and you decide to play a bad trick on Dolores.\n"+
                "During the final exam at the end of the year helped by Fred and George.\n" +
                "To do so, you have one minute and thirty seconds to set up at least six fireworks, or you distract Dolores to let Fred set up a two.\n" +
                " Either you set up two fireworks alone, but be careful if Dolores sees you you lose Hp and you lose a firework. Good luck !!";
        myExc.printseperator(5);
        slowPrint(message, 25);
    }
    public static void The_order_of_the_phoenix_Outro(){
        Execution myExc= new Execution();
        String message ="The fireworks are ready to be used and are used. Dolores is outraged and quits her professorship at Hogwarts.\n" +
                " In addition, you no longer had to prepare for an exam. You spend a calmer year!";
        myExc.printseperator(5);
        slowPrint(message, 25);
    }
    public static void The_half_blood_prince_Intro(){
        Execution myExc= new Execution();
        String message ="You spend your holidays in Grimmauld Square with Sirius Black, Hermione, Remus Lupin and the Weasley family at the headquarters of the Order of the Phoenix,\n"+
                "whose members try to awaken the consciences of other wizards and make publicly know about Voldemort's return.\n" +
                "Back at Hogwarts, you and your friends discover that Dolores Umbridge, the Minister's Under-Secretary of State , is the new Defense Against the Dark Arts teacher.\n"+
                "In class, the latter refuses to let the students practice magic, and makes you study only the theory by reading the manuals, which revolts everyone.\n"+
                "You receive many hours of detention from Umbridge for her insubordination, and especially when you insist on Voldemort's return.\n"+
                "Umbridge finds a way to control the school and Dumbledore's authority by enacting Education Decrees. You are fed up and you decide to play a bad trick on Dolores.\n"+
                "During the final exam at the end of the year helped by Fred and George.\n" +
                "To do so, you have one minute and thirty seconds to set up at least six fireworks, or you distract Dolores to let Fred set up a two.\n" +
                " Either you set up two fireworks alone, but be careful if Dolores sees you you lose Hp and you lose a firework. Good luck !!";
        myExc.printseperator(5);
        slowPrint(message, 25);
    }
    }



import java.lang.String;
import java.util.Timer;
import java.util.TimerTask;
public class Wizard extends Character {
    public String name;
    public static int nbr_de_potion=3;
    public static int hp;
    public int xp;
    Pet pet;
    int wand;
    String house;

    public Wizard(String name, Pet pet, int wand, String house, int maxHp,int xp){
        super(maxHp,xp);
        this.name=name;
        this.pet=pet;
        this.wand=wand;
        this.house=house;
        hp=maxHp;
    }



    @Override
    public int attack() {

        // Calcule les dégâts infligés par le sortilège du sorcier
        int finalDamage;
        int damage = Execution.Choose_spell();

        if(Execution.wizard.house.equals("Slytherin"))
        {
            finalDamage = damage + 5;
            return finalDamage;
        }else
            finalDamage = damage;
        return finalDamage ;
    }
    public double getLuck() {
        return Math.random();
    }
    public boolean isAlive() {

        return hp > 0;
    }
    //Votre objectif est de la distraire le temps que les feux d’artifice soient prêts à être utilisés.
    @Override
    public int defend() {
        // calcul de la probabilité de défense en fonction de la chance du sorcier
        double defenseProbability = 0.5 + this.getLuck() / 20.0;

        // génération d'un nombre aléatoire entre 0 et 1 pour déterminer si le sorcier réussit à esquiver l'attaque
        double random = Math.random();

        if (random < defenseProbability) {
            System.out.println("You successfully defended against the attack!\n");
            return 0; // aucun dégât n'est infligé
        } else {
            System.out.println("You failed to defend against the attack!\n");
            if (Execution.wizard.house.equals("Gryffindor")) {
                return 1; // 10 points de dégâts sont infligés
            } else return 2;
        }
    }

    public void setHp (int newHp){
        this.hp = newHp;
    }

    public static boolean demarrerMinuteur() {
       boolean compteurActif;
        int dureeMillis =120000;
        final Timer timer = new Timer();
        final TimerTask task = new TimerTask() {
            long debut = System.currentTimeMillis();
            @Override
            public void run() {
                long tempsEcoule = System.currentTimeMillis() - debut;
                long tempsRestant = dureeMillis - tempsEcoule;
                if (tempsRestant <= 0) {
                    timer.cancel();
                } else {
                    int secondesRestantes = (int) (tempsRestant / 1000);

                }
            }
        };
        timer.schedule(task, 0, 1000); // Démarrer immédiatement, répéter toutes les 1 seconde
        return compteurActif=true;
    }
    public static void distraireEnnemi() {
        int dureeMillis=15000;
        System.out.println("Le sorcier distrait l'ennemi pendant " + (dureeMillis / 1000) + " secondes...");
        try {
            Thread.sleep(dureeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("La distraction est terminée !");
    }
    public static int prepare_firework() {
        int firework;
        firework=Execution.firework+1;
        return firework;
    }
}



public enum Core {
    Phoenix_feather, Dragon_heartstring;

    public static Core choose_Core() {
        Game game = new Game();
        Execution myExc= new Execution();
        game.clearconsole();
        System.out.println("Now you have to choose the core for your wand");
        System.out.println("(1) Phoenix_feather");
        System.out.println("(2) Dragon_heartstring");
        int input = game.readInt("->", 2);
        if (input == 1) {
            System.out.println("A wand made of Phoenix feather, you are very wise");
            return Core.Phoenix_feather;
        }
        else {
            System.out.println("A wand made of Dragon heartstring, you are very wise");
            return Core.Dragon_heartstring;
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player legolas = new Player("Tim", 10, "Dagger", 900);
        System.out.println(legolas.toString());
        saveObject(legolas);


        Player stavros = new Player("Stavros", 10, "Excalibur" , 15000);
        System.out.println(stavros.toString());
        saveObject(stavros);

        stavros.setHealth(20000);
        System.out.println(stavros);
        stavros.setWeapon("Stormbringer");
        saveObject(stavros);
//        loadObject(tim);
        System.out.println(stavros);

        Savable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        saveObject(werewolf);


    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(Savable objectToSave) {
        for(int i=0; i<objectToSave.data().size(); i++) {
            System.out.println("Updating player ---> " + objectToSave.data().get(i) + ".");
        }
    }

    public static void loadObject(Savable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


}

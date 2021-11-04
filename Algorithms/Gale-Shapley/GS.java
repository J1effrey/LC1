import java.io.*;
import java.util.Objects;

public class GS {

    /**
     * people: people's preference matrix
     * pets: pets' preference matix
     *
     * peopleNames: array used to store people's names and number
     * petsName: array used to store pet's names and number
     *
     * peoplePool: store each person's current match pet (default 0)
     * petPool: store every pet's current match person (default 0)
     *
     * length: the first line of given data which represents how many pairs we need to make
     * pair: count of current successful pair
     */
    public static int[][] people;
    public static int[][] pets;
    public static String[] peopleNames;
    public static String[] petsNames;
    public static int[] peoplePool;
    public static int[] petPool;
    public static int pair = 0;
    public static int length;

    public static void main(String[] args) {

        // initial variables
        loadValue("program1data.txt");

        // begin pairing until all people and pet have been paired
        while (pair < length) {
            doPair(peoplePool, petPool);
        }

        // output
        for (int i = 0; i < peoplePool.length; i++) {
            System.out.println(peopleNames[i] + " " + "/" + " " + petsNames[peoplePool[i] - 1]);
        }
    }

    /**
     *
     * @param peoplePool  people's choice of pets
     * @param petPool  pets' choice of people
     */
    private static void doPair(int[] peoplePool, int[] petPool) {
        // match n people for one round
        for (int i = 0; i < length; i++) {
            // if current person has no pair
            if (peoplePool[i] == 0) {
                // find his first available pet and pet index in his preference array
                int petId = 0;
                int petIndex = 0;
                if (findFirstAvailablePet(i) != null) {
                    petId = findFirstAvailablePet(i)[0];
                    petIndex = findFirstAvailablePet(i)[1];
                }

                // selected pet has no pair
                if (petPool[petId - 1] == 0) {
                    // direct match
                    assignPet(i, petId);
                    pair++;
                } else {
                    // candidate1: the person that the pet matched before
                    int candidate1 = petPool[petId - 1];
                    // determine should we change pair
                    if (hasLargerPriority(candidate1, i + 1, petId - 1)) {
                        // the pet accept new person's pair and change pair
                        changePerson(candidate1, i, petId);
                    } else {
                        // the pet reject new person's pair
                        people[i][petIndex] = 0;
                    }
                }
            }
        }
    }

    /**
     * change pet's choice of pair from old person to new person
     * @param oldPerson  old pair person
     * @param newPerson new pair person
     * @param petId  pet id
     */
    private static void changePerson(int oldPerson, int newPerson, int petId) {
        for (int n = 0; n < length; n++) {
            if (people[oldPerson - 1][n] == petId) {
                people[oldPerson - 1][n] = 0;
                break;
            }
        }
        peoplePool[oldPerson - 1] = 0;
        peoplePool[newPerson] = petId;
        petPool[petId - 1] = newPerson + 1;
    }

    /**
     * when a pet has no pair, current person can match with the pet directly
     * @param newPeople  person id
     * @param petId pet id
     */
    private static void assignPet(int newPeople, int petId){
        peoplePool[newPeople] = petId;
        petPool[petId - 1] = newPeople + 1;
    }


    /**
     * find the first available pet that hasn't been paired yet
     * @param id  person id
     * @return  petId and its position in the person's preference array
     */
    private static int[] findFirstAvailablePet(int id) {
        for (int i = 0; i < people[id].length; i++) {
            if (people[id][i] != 0) {
                return new int[]{people[id][i], i};
            }
        }
        return null;
    }

    /**
     * determine if we should change the person the pet is paired with
     * @param oldPerson the person who is currently paired with the pet
     * @param newPerson the person who currently wants to match with the pet
     * @param petId the pet that two people compete
     * @return whether candidate2 appears before 2 in the pet's preference array
     */
    private static boolean hasLargerPriority(int oldPerson, int newPerson, int petId) { // 1 2 2
        for (int j = 0; pets[petId][j] != oldPerson; j++) {
            if (pets[petId][j] == newPerson) {
                return true;
            }
        }
        return false;
    }

    /**
     * load data to form arrays
     * @param fileName the data.txt we are going to load
     * @throws IOException
     */
    public static void loadValue(String fileName) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(GS.class.getClassLoader().getResourceAsStream(fileName))));
            String line = br.readLine();
            int n = Integer.parseInt(line);
            length = n;
            initialArrays();
            int i = 0;
            while (line != null) {
                line = br.readLine();
                i++;

                // set values to peopleNames
                if (i < n + 1) {
                    peopleNames[i - 1] = line;
                }

                // set values to people reference array
                if (i > n && i <= 2 * n) {
                    String[] s = line.split(" ");
                    for (int j = 0; j < n; j++) {
                        people[i - n - 1][j] = Integer.parseInt(s[j]);
                    }
                }

                // set values to petsNames
                if (i > 2 * n && i < 3 * n + 1) {
                    petsNames[i - 2 * n - 1] = line;
                }

                // set values to pet reference array
                if (i >= 3 * n + 1 && i < 4 * n + 1) {
                    String[] s = line.split(" ");
                    for (int j = 0; j < n; j++) {
                        pets[i - 3 * n - 1][j] = Integer.parseInt(s[j]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initialArrays() {
        peopleNames = new String[length];
        petsNames = new String[length];
        people = new int[length][length];
        pets = new int[length][length];
        peoplePool = new int[length];
        petPool = new int[length];
    }
}

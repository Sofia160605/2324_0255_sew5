package UE02_Labyrinth;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Sofia Angerer
 */

public class Labyrinth {
    public static String[][] maps = {{
            "############",
            "#  #     # #",
            "## # ### # #",
            "#  # # # # #",
            "## ### # # #",
            "#        # #",
            "## ####### #",
            "#          #",
            "# ######## #",
            "# #   #    #",
            "#   #   # ##",
            "######A#####"
    }, {
            "################################",
            "#                              #",
            "# ############################ #",
            "# # ###       ##  #          # #",
            "# #     ##### ### # ########## #",
            "# #   ##### #     # #      ### #",
            "# # ##### #   ###   # # ## # # #",
            "# # ### # ## ######## # ##   # #",
            "# ##### #  # #   #    #    ### #",
            "# # ### ## # # # # ####### # # #",
            "# #        # #   #     #     # #",
            "# ######## # ######### # ### # #",
            "# ####     #  # #   #  # ##### #",
            "# # #### #### # # # # ## # ### #",
            "#                      # #     #",
            "###########################A####"
    }, {
            "###########################A####",
            "#   #      ## # # ###  #     # #",
            "# ###### #### # # #### ##### # #",
            "# # ###  ## # # # #          # #",
            "# # ### ### # # # # # #### # # #",
            "# #     ### # # # # # ## # # # #",
            "# # # # ### # # # # ######## # #",
            "# # # #     #          #     # #",
            "# ### ################ # # # # #",
            "# #   #             ## # #   # #",
            "# # #### ############# # #   # #",
            "# #                    #     # #",
            "# # #################### # # # #",
            "# # #### #           ###     # #",
            "# # ## # ### ### ### ### # ### #",
            "# #    #     ##  ##  # ###   # #",
            "# ####   ###### #### # ###  ## #",
            "###########################A####"
    }, {
            "#############",
            "#           #",
            "#           #",
            "#           #",
            "###########A#"
    }};

    /**
     * Liest ein File in ein Labyrinth char Array ein
     *
     * @param path der Plan, ein String je Zeile
     * @return char[][] des Plans
     */
    public static char[][] fromFile(String path) {
        try {
            String[] stringMap = Files.readString(Paths.get(path)).trim().split("\n");

            return fromStrings(stringMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Wandelt (unveränderliche) Strings in Char-Arrays
     * @param map  der Plan, ein String je Zeile
     * @return char[][] des Plans
     */
    public static char[][] fromStrings(String[] map) {
        // TODO Code fehlt noch
        char[][] result = new char[map.length][map[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[i].length(); i1++) {
                result[i][i1] = map[i].charAt(i1);
            }
        }

        return result;
    }


    /**
     * Ausgabe des Layrinths
     * @param lab
     */
    public static void printLabyrinth(char[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int i1 = 0; i1 < lab[i].length; i1++) {
                System.out.print(lab[i][i1]);
            }
            System.out.println();
        }
    }

    /**
     * Suche den Weg
     * @param zeile     aktuelle Position
     * @param spalte     aktuelle Position
     * @param lab
     * @throws InterruptedException    für die verlangsamte Ausgabe mit sleep()
     */
    public static boolean suchen(int zeile, int spalte, char[][] lab) throws InterruptedException {
        char x = lab[zeile][spalte];
        if (x == 'A') {
            return true;
        } else if (x == ' ') {
            lab[zeile][spalte] = 'T';
            printLabyrinth(lab);
            //Thread.sleep(1000);
            return suchen(zeile+1, spalte, lab) ||
                    suchen(zeile, spalte+1, lab) ||
                    suchen(zeile-1, spalte, lab) ||
                    suchen(zeile, spalte-1, lab);
        } else {
            return false;
        }
    }

    /***
     * Findet alle möglichen Wege aus dem Labyrinth und zählt sie
     * @param zeile     aktuelle Position
     * @param spalte    aktuelle Position
     * @param lab       labyrinth, aus dem heraus gefunden werden soll
     * @return          anzahl an wegen nach draußen
     */
    public static int suchenAlle(int zeile, int spalte, char[][] lab) {
        char x = lab[zeile][spalte];
        if (x == 'A') {
            return 1;
        } else if (x != ' '){
            return 0;
        }


        lab[zeile][spalte] = 'T';
        int result = suchenAlle(zeile+1, spalte, lab) +
                suchenAlle(zeile-1, spalte, lab) +
                suchenAlle(zeile, spalte+1, lab) +
                suchenAlle(zeile, spalte-1, lab);


        lab[zeile][spalte] = ' ';

        return result;

    }

    public static void main(String[] args) throws InterruptedException {
        char[][] labyrinth = fromStrings(maps[2]);
        printLabyrinth(labyrinth);
        //System.out.println("Ausgang gefunden: " + (suchen(5, 5, labyrinth) ? "ja" : "nein"));
        System.out.println("Anzahl Wege: " + suchenAlle(5, 5, labyrinth));
    }
}

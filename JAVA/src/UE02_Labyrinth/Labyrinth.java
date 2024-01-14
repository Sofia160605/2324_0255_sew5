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



    public static void main(String[] args) throws InterruptedException {
        char[][] labyrinth = fromStrings(maps[2]);
        printLabyrinth(labyrinth);
        //System.out.println("Ausgang gefunden: " + (suchen(5, 5, labyrinth) ? "ja" : "nein"));
        //System.out.println("Anzahl Wege: " + suchenAlle(5, 5, labyrinth));
    }
}

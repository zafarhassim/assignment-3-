import java.io.*;

public class AlphabeticalList {
    public static void main(String[] args) throws IOException {
        String movies = "data/movies.csv";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(movies));


        String line = "";
        String cvsSplitBy = ",";
        String[] singer;
        final int size = 17; ///This is just an arbitrary size
        String[] original = new String[size];
        int j = 0;

        while ((line = bufferedReader.readLine()) != null) {
            singer = line.split(cvsSplitBy);
            original[j] = singer[1].toLowerCase().trim();
            // System.out.println(original[j]);
            j++;
            if (j == 16)
                break;
        }

        //separate name and year from title column
        String[] noInts = new String[original.length - 1];
        for (int a = 0; a <= noInts.length - 2; a++) {
            String name = original[a + 1].replaceAll("[0-9]+", "");
            noInts[a] = name;
            //System.out.println(noInts[a]);
        }

        //Remove parentheses
        for (int s = 0; s <= noInts.length - 2; s++) {
            noInts[s] = noInts[s].replace("(", "");
        }
        for (int q = 0; q <= noInts.length - 2; q++) {
            noInts[q] = noInts[q].replace(")", "");
            //System.out.println(noInts[q]);
        }

        //Get year movie was released
        String[] noTitle = new String[original.length - 1];
        for (int r = 0; r <= noTitle.length - 2; r++) {
            noTitle[r] = original[r + 1].replaceAll("[a-z]", "");
            // System.out.println(noTitle[r]);
        }

        //Remove parentheses
        for (int y = 0; y <= noTitle.length - 2; y++) {
            noTitle[y] = noTitle[y].replace(")", "");
            //System.out.println(noTitle[y]);
        }
        for (int h = 0; h <= noTitle.length - 2; h++) {
            noTitle[h] = noTitle[h].replace("(", "").trim();
            //System.out.println(noTitle[h]);
        }

        //convert year to int
         int[] year = new int[15];
         for (int t = 0; t <= 14; t++) {
             int newNum = Integer.parseInt(noTitle[t]);
             year[t] = newNum;
            // System.out.println(year[t]);
         }

         //Create binary search tree and insert movies
        Tree tree = new Tree();
        for (int i = 0; i <= original.length - 3; i++) {
            tree.insert(noInts[i], year[i]);
        }

        tree.inorderTraversal();

        //Example sets
         Tree.subSet(Tree.root, "balto", "sudden death");
         Tree.spaceAfter();
          Tree.subSet(Tree.root, "american president", "waiting to exhale");
            Tree.spaceAfter();
            Tree.subSet(Tree.root, "cutthroat island", "toy story");
            Tree.spaceAfter();

    }
}





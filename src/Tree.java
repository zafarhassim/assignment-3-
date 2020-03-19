import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tree {
    public  static TreeNode root;


    public void insert(String d, int i) {
        if (root == null) {
            root = new TreeNode(d, i);
            return;
        }
        TreeNode loc = root;
        while (true) {
            int compareResult = d.compareTo(loc.data);
            if (compareResult < 0) {
                if (loc.left != null) loc = loc.left;
                else {
                    loc.left = new TreeNode(d, i);
                    break;
                }
            } else if (compareResult > 0) {
                if (loc.right != null) loc = loc.right;
                else {
                    loc.right = new TreeNode(d, i);
                    break;
                }
            } else break;
        }
    }


    public void inorderTraversal() {
        inorderT(root);
    }

    public void inorderT(TreeNode t) {
        if (t != null) {
            inorderT(t.left);
            System.out.print(t.data + " ");
            inorderT(t.right);
        }
    }

    public TreeNode find(String string){
        TreeNode current = root;
        while(!current.data.equals(string))
        {
            if(string.compareTo(current.data) <= 0)
                current = current.left;
            else
                current = current.right;
            if(current == null)
                return null;
        } return current;
    }

    public static void subSet(TreeNode node, String k1, String k2) throws IOException {
        String homework = "data/homework.txt";
        File f = new File(homework);
        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw);

        if (node == null) {
            return;
        }
        if (0 > k1.compareTo(node.data)) {
            subSet(node.left, k1, k2);
        }
        if (k1.compareTo(node.data) <= 0 && k2.compareTo(node.data) >= 0) {
            System.out.print(node.data + " ");
            pw.println(node.data + " ");
            pw.close();
        }
        if (0 < k2.compareTo(node.data)) {
            subSet(node.right, k1, k2);
        }

    }

        public static void spaceAfter() throws IOException {
            String homework = "data/homework.txt";
            File f = new File(homework);
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("*********This marks the end of the subSet");
            pw.println(" ");
            pw.close();
        }
        }

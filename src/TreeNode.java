public class TreeNode {
        public String data;
        public int year;
        public TreeNode left, right;
        public TreeNode(String d, int i) { 
              data = d;
              year = i;
                left = right = null;
        }

        public String getData(){
            return data;
        }
}

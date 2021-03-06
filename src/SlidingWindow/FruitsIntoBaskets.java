package SlidingWindow;

public class FruitsIntoBaskets {

    public static boolean doesTreeExist(char trees[], char tree){
        for(char t: trees){
            if(t == tree)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // Input variables
        char trees[] = {'A', 'B', 'C', 'B', 'B', 'C'};
        int total_baskets = 2;

        // Other variables
        int max_fruits = 0, start = 0, end = 0, cur_basket = 0, i = 0;
        int total_trees = trees.length;
        int tree_map[] = new int[500];
        char visited_trees[] = new char[total_trees];

        //Logic
        while(start < total_trees && end < total_trees){

            char cur_tree = trees[end];
            int cur_ascii = (int) cur_tree;
            tree_map[cur_ascii] += 1;

            if(!doesTreeExist(visited_trees, cur_tree)){
                visited_trees[i++] = cur_tree;
                cur_basket += 1;
            }

            end += 1;

            if(cur_basket <= total_baskets){
                max_fruits = Math.max(max_fruits, end-start);
            }
            else{
                // Move start by one tree to the right
                char start_tree = trees[start];
                int start_ascii = (int) start_tree;
                start += 1;

                if(tree_map[start_ascii] == 1){
                    // Remove start tree from visited
                    tree_map[start_ascii] -= 1;
                    for(int j=0; j<visited_trees.length; j++){
                        if(visited_trees[j] == start_tree){
                            visited_trees[j] = 0;
                        }
                    }

                    //Subtract tree count from cur_basket
                    cur_basket -= 1;
                }
            }
        }
        System.out.println("Total number of fruits that can be fit into 2 baskets are " + max_fruits);




    }
}

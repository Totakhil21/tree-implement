import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Traversal {
  /**
   * @param args
   */
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10, null, null);
    root.left = new TreeNode<>(15);
    root.left.left = new TreeNode<>(39);
    root.left.right = new TreeNode<>(21);

    root.right = new TreeNode<>(20);
    root.right.left = new TreeNode<>(72);
    root.right.left.right = new TreeNode<>(42);


    TreeNode<String> StringRoot = new TreeNode<>("Hello", null, null);
    StringRoot.left = new TreeNode<>("Cat");
    StringRoot.left.left = new TreeNode<>("miku");
    StringRoot.left.right = new TreeNode<>("dog");

    StringRoot.right = new TreeNode<>("cyborg");
    StringRoot.right.left = new TreeNode<>("Jays");
    StringRoot.right.left.right = new TreeNode<>("robocop");

    // int result  = countNodes(root);
    // System.out.println(result);

    TreeNode<Integer> megaRoot = new TreeNode<>(1);

    TreeNode<Integer> currrent =megaRoot;
    for(int i = 2 ; i < 30001; i++){
      TreeNode<Integer> node = new TreeNode<>(i);
      currrent.right = node;
      currrent = node;
    }
    // preOrderr(root);

    // System.out.println("***************");
    // preOrderrIter(root);

    // levelOrderrIter(root);

    Set<Integer> set = convertToSet(root);
    System.out.println(set);

  }


  public static <T> Set<T> convertToSet(TreeNode<T>root){
    Set<T> set = new HashSet<>();
    convertToSetHelper(root,set);

    return set;
  }


  public static void preOrderrIter(TreeNode<?> current){
    Stack<TreeNode> stack = new Stack<>();

    stack.push(current);
    
    while (!stack.isEmpty() ){
      TreeNode<?> node = stack.pop();
      if(node == null){
        continue;
      }
      System.out.println(node.value);
      stack.push(node.right);
      stack.push(node.left);
    }
  }     



  public static <T> void convertToSetHelper(TreeNode <T> current, Set<T> set){

    if (current == null) return;
    set.add(current.value);

    convertToSetHelper(current.left,set);
    convertToSetHelper(current.right,set);
  }
    



  public static void levelOrderrIter(TreeNode<?> current){
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(current);
    
    while (!queue.isEmpty() ){
      TreeNode<?> node = queue.poll();
      if(node == null)
      System.out.println(node.value);
      queue.add(node.left);
      queue.add(node.right);
      
    }
  } 








  public static void preOrderr(TreeNode<?> current){
    //if null return 
    if(current == null) return;
    
    //write current
    System.out.println(current.value);
    //search left
    preOrderr(current.left);
    //search right
    preOrderr(current.right);


  }

  public static <E>  void postOrder (TreeNode<E> current){
    if(current == null) return;

    postOrder(current.left);
    postOrder(current.right);

    System.out.println(current.value);
  }


  public static void inOrder(TreeNode <?> current){
    if(current == null) return;
    inOrder(current.left);
    System.out.println(current.value);
    inOrder(current.right);
  }


  public static void greaterThan(TreeNode <Integer> current, int limit){
    if (current == null) return;
    if (current.value > limit)

    System.out.println(current.value);

    greaterThan(current.left,limit);
    greaterThan(current.right,limit);

  }

  public static int countNodes(TreeNode<?> current) {
    if (current == null) return 0;

    int leftCount = countNodes(current.left);
    int rightCount = countNodes(current.right);

    int totalCount = leftCount + rightCount + 1;

    return totalCount;

  }
}

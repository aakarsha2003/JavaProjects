package problem3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BinaryTree {
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			left=right=null;
		}
	}
	static Node buildTree(int[]arr) {
		if(arr.length==0 || arr[0]== -1)
		return null;
		Node root =new Node(arr[0]);
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		int i=1;
		while(q.isEmpty()&& i<arr.length) {
			Node curr=q.poll();
			if(arr[i]!=-1) {
				curr.left=new Node(arr[i]);
				q.add(curr.left);
			}
			i++;
			if(i>=arr.length)break;
			if (arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
		}
		return root;
	}
	static boolean isStrict(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null)
            return isStrict(root.left) && isStrict(root.right);
        return false; // only one child
    }
	static boolean isFull(Node root) {
        int depth = findDepth(root);
        return checkFull(root, 0, depth);

}
	static int findDepth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
	}
	static boolean checkFull(Node node, int level, int depth) {
        if (node == null)
            return true;
        if (node.left == null && node.right == null)
            return (depth == level + 1);
        if (node.left == null || node.right == null)
            return false;
        return checkFull(node.left, level + 1, depth) &&
               checkFull(node.right, level + 1, depth);
    }
	static boolean isComplete(Node root) {
        if (root == null) return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean nullSeen = false;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                nullSeen = true;
            } else {
                if (nullSeen) return false; // found a node after null
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
        arr[i] = sc.nextInt();
        Node root = buildTree(arr);
        boolean strict = isStrict(root);
        boolean full = isFull(root);
        boolean complete = isComplete(root);
        System.out.print((strict ? "StrictBinary " : "NotStrict "));
        System.out.print((full ? "FullBinary " : "NotFull "));
        System.out.print((complete ? "CompleteBinary" : "NotComplete"));
    }
}


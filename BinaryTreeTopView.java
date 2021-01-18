import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class BinaryTreeTopView {

    static class Node {
        int data;
        Node left;
        Node right;
        int level;

        Node(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = createTree(0);
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            if (!map.containsKey(currNode.level)) {
                map.put(currNode.level, currNode.data);
            }
            if (currNode.left != null)
                queue.add(currNode.left);
            if (currNode.right != null)
                queue.add(currNode.right);
        }
        System.out.println("Top View of the given tree is: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    static Node createTree(int level) {
        Node root = null;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1)
            return root;

        root = new Node(data, level);
        System.out.println("Left subtree data for " + data + ": ");
        root.left = createTree(level - 1);

        System.out.println("Right subtree data for " + data + ": ");
        root.right = createTree(level + 1);

        return root;
    }
}

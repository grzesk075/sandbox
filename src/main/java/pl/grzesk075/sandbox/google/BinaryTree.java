package pl.grzesk075.sandbox.google;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node copyBinaryTreeDFS(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.v);
        copy.l = copyBinaryTreeDFS(node.l);
        copy.r = copyBinaryTreeDFS(node.r);
        return copy;
    }

    Node copyBinaryTreeBFS(Node node) {
        Queue<Node> nodes = new LinkedList<>();
        Queue<Node> copies = new LinkedList<>();
        Node copy = new Node(node.v);
        nodes.offer(node);
        copies.offer(copy);
        while (!nodes.isEmpty()) {
            Node n = nodes.poll();
            Node c = copies.poll();
            if (n.l != null) {
                nodes.offer(n.l);
                c.l = new Node(n.l.v);
                copies.offer(c.l);
            }
            if (n.r != null) {
                nodes.offer(n.r);
                c.r = new Node(n.r.v);
                copies.offer(c.r);
            }
        }
        return copy;
    }

    Node invertBinaryTreeDFS(Node node) {
        if (node == null) return null;
        Node buff = node.l;
        node.l = invertBinaryTreeDFS(node.r);
        node.r = invertBinaryTreeDFS(buff);
        return node;
    }

    Node invertBinaryTreeBFS(Node node) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(node);
        while (!nodes.isEmpty()) {
            Node n = nodes.poll();
            Node buff = n.l;
            n.l = n.r;
            n.r = buff;
            if (n.l != null) nodes.offer(n.l);
            if (n.r != null) nodes.offer(n.r);
        }
        return node;
    }

    long sumBinaryTreeDFS(Node node) {
        if (node == null) return 0L;
        return node.v + sumBinaryTreeDFS(node.l) + sumBinaryTreeDFS(node.r);
    }

    long sumBinaryTreeBFS(Node node) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(node);
        long sum = 0L;
        while (!nodes.isEmpty()) {
            Node n = nodes.poll();
            sum += n.v;
            if (n.l != null) nodes.offer(n.l);
            if (n.r != null) nodes.offer(n.r);
        }
        return sum;
    }
}

class Node {
    int v;
    Node l, r;

    Node(int v) {
        this.v = v;
    }
}

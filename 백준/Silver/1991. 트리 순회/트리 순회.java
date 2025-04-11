import java.util.Scanner;

class Node<E> {
    public E item;
    public Node<E> leftLink;
    public Node<E> rightLink;

    public Node(E item, Node leftLink, Node rightLink){
        this.item = item;
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }

    public Node(E item){
        this.item = item;
        this.leftLink = null;
        this.rightLink = null;
    }
}


class MyTree <E> {
    private Node root;
    private Node lastNode;


    public void MyTree(){
        root = new Node(null);
        lastNode = new Node(null);
    }

    public void addNode(E item, E leftLinkItem, E rightLinkItem){
        Node tempNode;
        if(root == null){
            root = new Node(item, new Node(leftLinkItem), new Node(rightLinkItem));
            //System.err.println("root : " + root.item + " /root left child : " + root.leftLink.item);
            return;
        }
        tempNode = searchNode(root, item);
        //System.err.println("tempNode : " + tempNode.item);
        if(tempNode == null)
            return;
        tempNode.leftLink = new Node(leftLinkItem);
        tempNode.rightLink = new Node(rightLinkItem);
    }

    public Node searchNode(Node root, E item){
        Node returnNode;
        if(root == null)
            return null;
        if(root.item == item) {
            //System.out.println("Searched root : " + root.item);
            return root;
        }
        if((returnNode = searchNode(root.leftLink, item)) != null)
            return returnNode;
        if((returnNode = searchNode(root.rightLink, item)) != null)
            return returnNode;
        return null;
    }

    public void preOrder(Node root){
        if(root.item == null)
            return;
        System.out.print(root.item);
        preOrder(root.leftLink);
        preOrder(root.rightLink);
    }
    public void inOrder(Node root){
        if(root.item == null)
            return;
        inOrder(root.leftLink);
        System.out.print(root.item);
        inOrder(root.rightLink);
    }
    public void postOrder(Node root){
        if(root.item == null)
            return;
        postOrder(root.leftLink);
        postOrder(root.rightLink);
        System.out.print(root.item);
    }
    public Node getRoot(){
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyTree<Character> tree = new MyTree<Character>();

        int loopNum;
        Character inputRoot, inputLeft, inputRight;
        loopNum = scanner.nextInt();
        for(int i = 0; i < loopNum; i++){
            inputRoot = (char)scanner.next().charAt(0);
            inputLeft = (char)scanner.next().charAt(0);
            if(inputLeft == '.')
                inputLeft = null;
            inputRight = (char)scanner.next().charAt(0);
            if(inputRight == '.')
                inputRight = null;
            tree.addNode(inputRoot, inputLeft, inputRight);
            //System.out.printf("%c %c %c\n", inputRoot, inputLeft, inputRight);
        }
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());
        System.out.println();
    }
}
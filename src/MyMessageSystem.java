import java.util.Scanner;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class MessQueue {
    private Node front;
    private Node rear;
    private int size;

    public MessQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(String message) {
        Node newNode = new Node(message);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public String dequeue() {
        if (front == null) {
            return null;
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

class MessStack {
    private Node top;

    public MessStack() {
        this.top = null;
    }

    public void push(String message) {
        Node newNode = new Node(message);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class MyMessageSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        MessQueue messageQueue = new MessQueue();
        MessStack messageStack = new MessStack();

        while (true) {
            System.out.print("Nhap tin nhan (an '1' de thoat): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("1")) {
                break;
            }
            
            processUserMessage(userInput, messageQueue, messageStack);
           
        }
        displayUserMessages(messageStack);
        scanner.close();
    }

    private static void processUserMessage(String userInput, MessQueue messageQueue, MessStack messageStack) {
        if (userInput.length() == 0) {
            System.out.println("Invalid message: Khong co tin nhan de hien thi");
           
        }  else if(userInput.length() > 2) {
            System.out.println("Invalid message: Tin nhan qua 100 ki tu");
        } else{
            messageQueue.enqueue(userInput);
            messageStack.push(userInput);
            System.out.println("Da gui: " + userInput);
        }
    }

    private static void displayUserMessages(MessStack messageStack) {
        System.out.println("Tin nhan da gui:");
        while (!messageStack.isEmpty()) {
            String message = messageStack.pop();
            System.out.println(message);
        }
    }
}
public class Lesson {

    public static void main(String[] args) {

        System.out.println("--------Stack--------");
        MyStack<Integer> stack = new MyStack<>();
        stack.add(4);
        stack.add(6);
        System.out.println(stack.remove());
        stack.add(1);
        System.out.println(stack.remove());
        System.out.println(stack.remove());

        System.out.println("--------Queue--------");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(4);
        queue.add(6);
        System.out.println(queue.remove());
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println("--------Priority Queue--------");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4, 10);
        priorityQueue.add(6, 5);
        priorityQueue.add(1, 11);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());

        System.out.println("--------Deck Queue--------");
        DeckQueue<Integer> deckQueue = new DeckQueue<>();
        deckQueue.add(4);
        deckQueue.add(1);
        deckQueue.addBegin(6);
        System.out.println(deckQueue.remove());
        System.out.println(deckQueue.removeLast());
        System.out.println(deckQueue.remove());

        System.out.println("--------Revert String--------");
        RevertString revertString = new RevertString("Hello world");
        System.out.println(revertString.revert());
    }
}

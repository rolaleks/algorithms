public class Lesson {
    public static void main(String[] args) {
        /*
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insertFirst("Cat");
        System.out.println(list.toString());
        list.insert(0, "Dog");
        System.out.println(list.toString());
        list.insertFirst("Fox");
        list.insertLast("Fish");
        System.out.println(list.toString());

         */

        MyLinkedStack<String> stack = new MyLinkedStack<>();
        stack.add("Cat");
        stack.add("Dog");
        System.out.println(stack.remove());
        System.out.println(stack.peak());
        stack.add("Fox");
        System.out.println(stack.remove());
        System.out.println(stack.remove());
    }
}

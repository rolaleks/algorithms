public class RevertString {

    private String str;

    public RevertString(String string) {
        this.str = string;
    }


    public String revert() {
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < this.str.length(); i++) {
            stack.add(this.str.charAt(i));
        }

        String out = "";
        while (!stack.isEmpty()) {
            out += stack.remove();
        }
        return out;
    }
}

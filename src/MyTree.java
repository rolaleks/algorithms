public class MyTree {


    private Item root;

    public void put(int key, int value) {

        root = put(root, key, value, 1);
    }

    private Item put(Item item, int key, int value, int level) {
        if (item == null) {
            return new Item(key, value, level);
        }
        if (item.key == key) {
            item.value = value;
        } else if (item.key < key) {
            item.left = put(item.left, key, value, level + 1);
        } else {
            item.right = put(item.right, key, value, level + 1);
        }
        item.size = item.leftSize() + item.rightSize() + 1;
        return item;
    }


    public boolean isEmpty() {
        return root == null;
    }


    public int maxLevel() {

        return isEmpty() ? 0 : root.maxLevel();
    }

    public boolean isBalanced() {
        return isEmpty() || Math.abs(root.leftMaxLevel() - root.rightMaxLevel()) < 2;
    }

    public int size() {
        return isEmpty() ? 0 : root.size;
    }

    private class Item {
        int key;
        int value;
        Item left;
        Item right;
        int size;
        int level;

        public Item(int key, int value, int level) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.level = level;
        }


        public int size(Item item) {

            return item == null ? 0 : item.size;
        }

        public int leftSize() {

            return size(this.left);
        }

        public int rightSize() {

            return size(this.right);
        }

        private int maxLevel(Item item) {
            if (item == null) {
                return 0;
            }
            int maxChild = Math.max(item.rightMaxLevel(), item.leftMaxLevel());
            return Math.max(maxChild, item.level);
        }

        private int maxLevel() {
            return maxLevel(this);
        }

        public int rightMaxLevel() {

            return maxLevel(this.right);
        }

        public int leftMaxLevel() {

            return maxLevel(this.left);
        }

    }

}

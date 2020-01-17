import java.util.ArrayList;

public class Pack {

    private int size;
    private int resultValue;
    private ArrayList<Item> list;
    private ArrayList<Integer> packList;

    public Pack(int size) {
        this.size = size;
        this.list = new ArrayList<>();
    }

    private class Item {

        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public int calculate(boolean uniquePack) {

        ArrayList<Integer> bestPack = getEmptyPackList();
        int result = perform(list.size(), size, bestPack, uniquePack);
        this.packList = bestPack;
        return result;
    }

    private int perform(int itemCount, int packSize, ArrayList<Integer> packList, boolean uniquePack) {
        int value = 0;
        int lastIndex = itemCount - 1;
        ArrayList<Integer> bestPack = getEmptyPackList();
        if (lastIndex > 0) {
            for (int i = 0; i * list.get(lastIndex).weight <= packSize && (i <= 1 || !uniquePack); i++) {
                int subResult = i * list.get(lastIndex).value + perform(itemCount - 1, packSize - i * list.get(lastIndex).weight, bestPack, uniquePack);
                if (subResult > value) {
                    value = subResult;
                    packList.set(lastIndex, i);
                    for (int j = 0; j < lastIndex; j++) {
                        packList.set(j, bestPack.get(j));
                    }
                }
            }
            return value;
        }

        int itemsLeft = packSize / list.get(lastIndex).weight;
        if (itemsLeft > 0 && uniquePack) {
            itemsLeft = 1;
        }
        packList.set(lastIndex, itemsLeft);
        return list.get(lastIndex).value * itemsLeft;
    }

    private ArrayList<Integer> getEmptyPackList() {
        packList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            packList.add(0);
        }
        return packList;
    }


    public void addItem(int value, int weight) {
        list.add(new Item(value, weight));
    }

    public void info() {
        System.out.println(packList);
    }
}

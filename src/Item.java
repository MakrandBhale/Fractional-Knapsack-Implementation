public class Item implements Comparable<Item>{
    private int profit, weight;
    private int name;

    private double fractionalProfit = 0;
    Item(int name, int profit, int weight){
        this.name = name;
        this.profit = profit;
        this.weight = weight;
        this.fractionalProfit = (double) this.profit/this.weight;
    }

    int getProfit() {
        return profit;
    }

    int getWeight() {
        return weight;
    }

    int getName() {
        return name;
    }

    public double getFractionalProfit() {
        return fractionalProfit;
    }

    @Override
    public int compareTo(Item i){
        return Double.compare(i.fractionalProfit,this.fractionalProfit);
    }
}

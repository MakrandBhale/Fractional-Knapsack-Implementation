import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Knapsack {
    private ArrayList<Item> items = new ArrayList<>();
    private int weightLimit;
    private double totalProfit = 0;

    void getUserInput(){
        weightLimit = getInput("Enter bag capacity: ");
        int totalItems = getInput("Enter total number of items: ");
        for(int i = 1; i <= totalItems; i++){
            items.add(
                    new Item(
                            i,
                            getInput("Enter profit for object " + i + ": "),
                            getInput("Enter weight for object: " + i + ": ")
                    )
            );
        }
        printContent("Object list \n");

    }

    private void print(String msg){
        System.out.print(msg);
    }

    private int getInput(String msg){
        print(msg);
        return new Scanner(System.in).nextInt();
    }

    private void printContent(String msg){
        print(msg);
        print("Object \t Weight \t Profit \n");
        for(Item i : items ){
            print(i.getName() + " \t " + i. getWeight() + " \t " + i.getProfit() + "\n");
        }
    }
    void sortItems(){
        Collections.sort(items);
        printContent("Object list after sorting\n");
    }

    void pickItems(){
        print("\nObject Selected\n");
        for(Item i : items){
            if(weightLimit == 0) break;

            if(i.getWeight() <= weightLimit){
                totalProfit = totalProfit + i.getProfit();
                weightLimit = weightLimit - i.getWeight();
                print("Object: " + i.getName() + "\tProfit: " + i.getProfit() + "\tRemaining Weight: " + weightLimit + "\n");
            } else {
                /*bag capacity is less than items weight, divide the items, take fraction of profit*/

                double fractionalProfit = (double) ((weightLimit * i.getProfit()) / i.getWeight());
                totalProfit = totalProfit + fractionalProfit;
                print("Object: " + i.getName() + "\tProfit: " + fractionalProfit + "\tRemaining Weight: " + 0 + "\n");
                /*as it will always be the last item to go into the bag put remaining weight = 0*/
                weightLimit = 0;
            }

        }
        print("\nTotal Profit is " + totalProfit);
    }


}

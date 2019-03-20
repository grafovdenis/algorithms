package jv;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Example
In:
3 50
60 20
100 50
120 30
Out:
180.000
*/
public class Knapsack {
    public static class Item {
        Double cost;
        Double weight;
        Double ratio;

        public Item(double v, double v1) {
            this.cost = v;
            this.weight = v1;
            this.ratio = cost / weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        Double W = Double.parseDouble(input[1]);
        ArrayList<Item> items = new ArrayList<Item>();
        Double result = 0.0;

        for (int i = 0; i < n; i++) {
            String[] inp = br.readLine().split(" ");
            items.add(new Item(Double.parseDouble(inp[0]), Double.parseDouble(inp[1])));
        }

        items.sort(Comparator.comparing(o -> o.ratio));
        Collections.reverse(items);

        for (Item el : items) {
            if (W > el.weight) {
                result += el.cost;
                W -= el.weight;
            } else {
                result += W / el.weight * el.cost;
            }
        }

        System.out.println(result);
    }
}

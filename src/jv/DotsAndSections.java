package jv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Example
In:
4
4 7
1 3
2 5
5 6
Out:
2
3 6
*/
public class DotsAndSections {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfSections = Integer.parseInt(br.readLine());
        ArrayList<List<Integer>> sections = new ArrayList<>();
        ArrayList<Integer> rights = new ArrayList<>();
        for (int i = 0; i < numOfSections; i++) {
            String[] input = br.readLine().split(" ");
            sections.add(Collections.singletonList(Integer.parseInt(input[0], Integer.parseInt(input[1]))));
        }

        sections.sort(Comparator.comparing(o -> o.get(1)));

        List<Integer> connected = new ArrayList<>();

        for (int i = 0; i < numOfSections; i++) {
            int right = sections.get(i).get(1);
            for (int j = 0; j < numOfSections; j++) {
                if (j != i && !connected.contains(i)) {
                    if (right >= sections.get(j).get(0) && right <= sections.get(j).get(1)) {
                        rights.add(right);
                        connected.add(j);
                    } else if (!connected.contains(j)) {
                        rights.add(right);
                        connected.add(i);
                    }
                }
            }
        }

        if (!connected.contains(numOfSections - 1))
            rights.add(sections.get(numOfSections - 1).get(1));
        System.out.println(rights.size());
        for (int el: rights) {
            System.out.print(el + " ");
        }
    }
}

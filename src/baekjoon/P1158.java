package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split(" ");
        int num = Integer.parseInt(array[0]);
        int turn = Integer.parseInt(array[1]);

        LinkedList<Integer> list = new LinkedList();
        List<Integer> removeList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            list.add(i);
        }
        ListIterator<Integer> iter = list.listIterator();//커서는 맨앞에 위치한다.
        // 리스트가 모두 빌 떄까지 진행
        while (!list.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                // 다음 값이 있는 경우
                if (iter.hasNext()) {
                    if(i==2)
                        removeList.add(iter.next());
                    else
                        iter.next();
                }
                // 다음 값이 없는 경우
                else{
                    // 커서를 가장 앞으로 이동시킴
                    while (iter.hasPrevious())
                        iter.previous();
                    if(i==2)
                        removeList.add(iter.next());
                    else
                        iter.next();
                }
            }
            // 3칸 이동 후 삭제
            iter.remove();
        }
        System.out.print("<");
        for (int i = 0; i < removeList.size(); i++) {
            System.out.print(removeList.get(i));
            if(i!=removeList.size()-1)
                System.out.print(", ");
        }
        System.out.print(">");

    }
}

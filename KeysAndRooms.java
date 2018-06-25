import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(0);
        l2.add(1);
        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        List<Integer> l4 = new ArrayList<>();
        l4.add(0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(l1);
        rooms.add(l2);
        rooms.add(l3);
        rooms.add(l4);
        System.out.println(keysAndRooms.canVisitAllRooms(rooms));
    }

    private boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null) {
            return false;
        }
        if (rooms.size() == 1) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited.add(0);
        while (!stack.empty()) {
            int index = stack.peek();
            if (rooms.get(index).isEmpty()) {
                stack.pop();
            } else if (!visited.contains(rooms.get(index).get(0))) {
                stack.push(rooms.get(index).get(0));
                visited.add(rooms.get(index).get(0));
                rooms.get(index).remove(0);
            } else {
                rooms.get(index).remove(0);
            }
        }
        return visited.size() == rooms.size();
    }
}

package day0118;

import model.UserDTO;

public class Test {
    public static void main(String[] args) {
        /*TreeSet treeSet = new TreeSet();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(0);
        treeSet.printSet();*/

        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 3; i++) {
            UserDTO u = new UserDTO();
            u.setId(i);
            u.setUsername("U" + i);
            u.setNickname("사용자" + i);
            hashMap.put(u.getUsername(), u);
        }

        System.out.println(hashMap.get("U1"));
    }
}

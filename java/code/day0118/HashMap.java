package day0118;

import model.UserDTO;

import java.util.ArrayList;
import java.util.HashSet;

public class HashMap {
    // HashSet<String> keySet = new HashSet<>();
    ArrayList<String> keySet = new ArrayList<>();
    ArrayList<UserDTO> valueList = new ArrayList<>();

    public UserDTO get(String key) {
        if (keySet.contains(key)) {
            //String[] temp = keySet.toArray(new String[0]);
            int index = keySet.indexOf(key);
            return valueList.get(index);
        }
        return null;
    }

    public ArrayList<String> keySet() {
        return keySet;
    }

    public void put(String key, UserDTO value) {
        if (!keySet.contains(key)) {
            keySet.add(key);
            valueList.add(value);
        }
    }

    public void remove(String key) {
        int index = keySet.indexOf(key);
        if (index != -1) {
            keySet.remove(index);
            valueList.remove(index);
        }
    }



    /*public String[] keyList = new String[0];
    public UserDTO[] valueList = new UserDTO[0];

    public void put(String key, UserDTO value) {
        if (!containsKey(key)) {
            String[] tempKey = new String[keyList.length + 1];
            UserDTO[] tempValue = new UserDTO[valueList.length + 1];
            for (int i = 0; i < keyList.length; i++) {
                tempKey[i] = keyList[i];
                tempValue[i] = valueList[i];
            }
            tempKey[keyList.length] = key;
            tempValue[valueList.length] = value;
        }
    }

    public boolean containsKey(String key) {
        for (int i = 0; i < keyList.length; i++) {
            if (keyList[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public UserDTO get(String key) {
        for (int i = 0; i < keyList.length; i++) {
            if (keyList[i].equals(key)) {
                return valueList[i];
            }
        }
        return null;
    }

    public String[] keySet() {
        String[] temp = new String[keyList.length];
        for (int i = 0; i < keyList.length; i++) {
            temp[i] = keyList[i];
        }
        return temp;
    }*/
}

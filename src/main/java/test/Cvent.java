package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cvent {

  public int solution(int[] ranks) {
    Map<Integer, Integer> frequency = new HashMap<>();

    for (int index = 0; index < ranks.length; index++) {
      int element = ranks[index];
      Integer count = frequency.get(element);
      if (count == null) {
        count = 0;
      }
      frequency.put(element, count + 1);
    }

    int soldierCount = 0;

    for (Entry<Integer, Integer> entry : frequency.entrySet()) {

      Integer key = entry.getKey();
      Integer value = entry.getValue();

      Integer superior = frequency.get(key + 1);
      if (superior != null) {
        soldierCount += value;
      }

    }
    return soldierCount;

  }
}

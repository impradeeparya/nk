package hashmap;

public class HashMapper {

    public static void main(String[] args) {

        CustomHashMap<String, String> customHashMap = new CustomHashMap();

        customHashMap.put("1", "hello");
        customHashMap.put("2", "world1");
        customHashMap.put("3", "world2");
        customHashMap.put("4", "world3");
        customHashMap.put("5", "world4");
        customHashMap.put("6", "world5");
        customHashMap.put("7", "world6");
        customHashMap.put("8", "world7");
        customHashMap.put("9", "world8");
        customHashMap.put("10", "world9");
        customHashMap.put("11", "world10");
        customHashMap.put("12", "world11");

        System.out.println(customHashMap);
    }
}

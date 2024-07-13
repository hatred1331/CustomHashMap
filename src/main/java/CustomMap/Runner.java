package CustomMap;

public class Runner {
    public static void main(String[] args) {

        Node<String, String> testNode1= new Node<>("First", "Test");
        Node<String, String> testNode2= new Node<>("Second", "Test");
        Node<String, String> testNode3= new Node<>("First", "Test");

        NodeList<String, String> list = new NodeList<>();
        list.add(testNode1);
        list.add(testNode2);

        list.add("First", "New CustomHashMap.Node");

        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("First", "Test");
        map.put("Sec", "Test");
        System.out.println(map.size());
        System.out.println(map.get("First"));
        System.out.println(map.get("Sec"));
        map.put("First", "NewTest");
        System.out.println(map.get("First"));
        map.clear();
        System.out.println(map.size());
        System.out.println(map.get("First"));


    }
}

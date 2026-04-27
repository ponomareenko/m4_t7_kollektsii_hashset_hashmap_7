import java.util.*;

public class Main {
    static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();

        Address addresOne = new Address("Russia", "Moscow");
        Address addresTwo = new Address("USA", "New York");
        Address addresThree = new Address("Cyprus", "Larnaca");
        Address addresFour = new Address("Russia", "Anapa");

        costPerAddress.put(addresOne, 100);
        costPerAddress.put(addresTwo, 700);
        costPerAddress.put(addresThree, 400);
        costPerAddress.put(addresFour, 200);

        NewOrder.fillingNewOrder(costPerAddress);
    }

//    public static int[] compareAddress(String country, String city, String weight, Map<Address, Integer> costPerAddress) {
//        int[] priceAndUnicCount = new int[2];
//        Set<String> uniqueCountries = new HashSet<>();
//        for (Map.Entry<Address, Integer> kv : costPerAddress.entrySet()) {
//            if (country.equals(kv.getKey().country) && city.equals(kv.getKey().city)) {
//                try {
//                    priceAndUnicCount[0] = Integer.parseInt(weight) * kv.getValue();
//                    if (priceAndUnicCount[1] > 0) {
//                        return priceAndUnicCount;
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Введите корректный вес!");
//                }
//            }
//            uniqueCountries.add(kv.getKey().country);
//        }
//        priceAndUnicCount[1] = uniqueCountries.size();
//        return priceAndUnicCount;
//    }

    public static int[] compareAddress(String country, String city, String weight, Map<Address, Integer> costPerAddress) {
        int[] priceAndUnicCount = new int[2];
        Set<String> uniqueCountries = new HashSet<>();
        country = "Russia";
        city = "Moscow";

        Map<Address, Integer> checkAddress = new HashMap<>();
        checkAddress.put(new Address(country, city), 0);

//        System.out.println(costPerAddress.keySet().hashCode());
//        System.out.println(costPerAddress.get(checkAddress));
//        System.out.println(costPerAddress.containsKey(checkAddress));

        if (costPerAddress.containsKey(checkAddress)) {
            priceAndUnicCount[0] = Integer.parseInt(weight) * costPerAddress.get(checkAddress);
        }

        for (Map.Entry<Address, Integer> kv : costPerAddress.entrySet()) {
            if (country.equals(kv.getKey().country) && city.equals(kv.getKey().city)) {
                try {
//                    priceAndUnicCount[0] = Integer.parseInt(weight) * kv.getValue();
                    if (priceAndUnicCount[1] > 0) {
                        return priceAndUnicCount;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите корректный вес!");
                }
            }
            uniqueCountries.add(kv.getKey().country);
        }
        priceAndUnicCount[1] = uniqueCountries.size();
        return priceAndUnicCount;
    }
}
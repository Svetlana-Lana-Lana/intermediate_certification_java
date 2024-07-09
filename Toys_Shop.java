import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Toys_Shop {

    private static PriorityQueue<Toy> toys;

    public Toys_Shop() {
        toys = new PriorityQueue<>((t1, t2) -> t2.weight - t1.weight);
    }

    public void putToy(int id, String name, int weight) {
        Toy toy = new Toy(id, name, weight);
        toys.add(toy);
    }

    void writeResultToFile(PriorityQueue<Toy> toys) {

        try (FileWriter writer = new FileWriter("Results.txt")) {
            while (!toys.isEmpty()) {
                Toy toy = toys.poll();
                for (int i = 0; i < toy.getWeight(); i++) {
                    writer.write(String.format("Выпала игрушка id %s, название -  %s\n", toy.getId(), toy.getName()));
                }
            }
        } catch (IOException e) {
            System.err.println("ошибка" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Toys_Shop shop = new Toys_Shop();
        shop.putToy(1, "constructor", 2);
        shop.putToy(2, "robot", 2);
        shop.putToy(3, "doll", 6);

        shop.writeResultToFile(toys);
    }
}


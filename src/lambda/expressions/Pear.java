package lambda.expressions;

public class Pear {
    private int weight;

    public Pear(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "A pear of " + weight + " grams";
    }
}

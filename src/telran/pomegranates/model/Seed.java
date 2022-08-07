package telran.pomegranates.model;

public class Seed {
    double Weight;

    public Seed(double weight) {
        Weight = weight;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seed)) return false;

        Seed seed = (Seed) o;

        return Double.compare(seed.Weight, Weight) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(Weight);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "telran.pomegranates.model.Seed{" +
                "Weight=" + Weight +
                '}';
    }
}

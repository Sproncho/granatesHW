package telran.pomegranates.model;

import java.util.*;

public class Pomegranate implements Iterable<Seed> {
    private List<Seed> seedList = new ArrayList<>();

    public Pomegranate(Collection<Seed> seeds) {
        this.seedList.addAll(seeds);
    }

    public Pomegranate() {
    }

    @Override
    public Iterator<Seed> iterator() {
        return new Iterator<Seed>() {
            int ind = 0;
            @Override
            public boolean hasNext() {
                return ind < seedList.size();
            }

            @Override
            public Seed next() {
                Seed res = seedList.get(ind);
                ind++;
                return res;
            }
        };

    }
}

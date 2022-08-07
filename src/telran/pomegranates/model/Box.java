package telran.pomegranates.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Box implements Iterable<Pomegranate>{
    private List<Pomegranate>granates = new ArrayList<>();
    private String name;

    public Box(Collection<Pomegranate> granates, String name) {
        this.granates.addAll(granates);
        this.name = name;
    }

    public Box(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return new Iterator<Pomegranate>() {
            int ind = 0;
            @Override
            public boolean hasNext() {
                return ind < granates.size();
            }

            @Override
            public Pomegranate next() {
                Pomegranate res = granates.get(ind);
                ind++;
                return res;
            }
        };
    }
}

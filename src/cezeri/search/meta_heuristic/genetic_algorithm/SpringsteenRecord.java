package cezeri.search.meta_heuristic.genetic_algorithm;

import static java.util.Objects.requireNonNull;

import io.jenetics.util.ISeq;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpringsteenRecord {

    String name;
    double price;
    ISeq<String> songs;

    public SpringsteenRecord(String name, double price, ISeq<String> songs) {
        this.name = requireNonNull(name);
        this.price = price;
        this.songs = requireNonNull(songs);
    }

}

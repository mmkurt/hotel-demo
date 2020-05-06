package mk.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    HotelRepository repository;

    public DBSeeder(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Istanbul", "Turkey"),
                Arrays.asList(
                        new Review("Mustafa", 9, true),
                        new Review("Mary", 7, true),
                        new Review("Tugce", 6, false)
                )
        );

        Hotel hilton = new Hotel(
                "Hilton",
                150,
                new Address("Amsterdam", "Netherlands"),
                Arrays.asList(
                        new Review("Van", 10, false),
                        new Review("Lancelot", 5, true)
                )
        );

        Hotel divan = new Hotel(
                "Divan",
                80,
                new Address("Budapest", "Hungary"),
                Arrays.asList(
                        new Review("Leyla", 8, true),
                        new Review("Ahmet", 5, false)
                )
        );

        /**
         * Delete all data before inserting any
         */
        this.repository.deleteAll();

        // Add hotels to the DB
        List<Hotel> hotels = Arrays.asList(marriot, ibis, hilton, divan);
        this.repository.save(marriot);
        this.repository.save(ibis);
        this.repository.save(hilton);
        this.repository.save(divan);


    }
}

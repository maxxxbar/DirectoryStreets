package entities;

import java.util.Objects;

public class Item {
    private final String city;
    private final String street;
    private final String house;
    private final String floor;

    public Item(String city, String street, String house, String floor) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "entities.Item{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(city, item.city) && Objects.equals(street, item.street) && Objects.equals(house, item.house) && Objects.equals(floor, item.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, floor);
    }
}

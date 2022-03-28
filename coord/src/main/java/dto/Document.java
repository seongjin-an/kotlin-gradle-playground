package dto;

public class Document {
    private Address address;
    private String address_name;
    private String address_type;
    private RoadAddress road_address;
    private String x;
    private String y;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getAddress_type() {
        return address_type;
    }

    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }

    public RoadAddress getRoad_address() {
        return road_address;
    }

    public void setRoad_address(RoadAddress road_address) {
        this.road_address = road_address;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Document{" +
                "address=" + address +
                ", address_name='" + address_name + '\'' +
                ", address_type='" + address_type + '\'' +
                ", road_address=" + road_address +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}

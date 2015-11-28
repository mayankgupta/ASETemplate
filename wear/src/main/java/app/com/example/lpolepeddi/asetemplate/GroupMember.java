package app.com.example.lpolepeddi.asetemplate;

public class GroupMember {
    public String name;
    public double lat;
    public double lng;
    public int timestamp;

    public GroupMember(String name, double lat, double lng, int timestamp) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
    }
}

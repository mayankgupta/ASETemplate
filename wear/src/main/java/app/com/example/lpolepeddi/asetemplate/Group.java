package app.com.example.lpolepeddi.asetemplate;

public class Group {
    public String name;
    public int timestamp;
    GroupMember[] members;

    public Group(String name, int timestamp, GroupMember[] members) {
        this.name = name;
        this.timestamp = timestamp;
        this.members = members;
    }
}
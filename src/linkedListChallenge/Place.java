package linkedListChallenge;


class Place {
    private String name;
    private int distance;
    
    public Place(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
    
    public String getName() {
        return name;
    }
    
    public int getDistance() {
        return distance;
    }
    
    @Override
    public String toString() {
        return name + " (" + distance + " km)";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Place place = (Place) obj;
        return name.equals(place.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

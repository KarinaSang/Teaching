package game.data;

public record TowerData(
        String name,
        String imageName,
        int cost
) {
}

//public class OldTowerData {
//    private String name;
//    private String imageName;
//
//    public OldTowerData(String name, String imageName) {
//        this.name = name;
//        this.imageName = imageName;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImageName() {
//        return imageName;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//
//
//}

package ir.ea2.android_materialdesign.models;

public class UserModel {
    private int itemAvatar;
    private String itemName;

    public UserModel(int itemAvatar, String itemName) {
        this.itemAvatar = itemAvatar;
        this.itemName = itemName;
    }

    public int getItemAvatar() {
        return itemAvatar;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemAvatar(int itemAvatar) {
        this.itemAvatar = itemAvatar;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}

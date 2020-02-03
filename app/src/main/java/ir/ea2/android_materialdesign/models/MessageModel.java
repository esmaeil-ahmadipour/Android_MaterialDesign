package ir.ea2.android_materialdesign.models;

import java.io.Serializable;

public class MessageModel implements Serializable {
    private int avatarItem;
    private String nameItem;
    private String lastMessageItem;

    public MessageModel(int avatarItem, String nameItem, String lastMessageItem) {
        this.avatarItem = avatarItem;
        this.nameItem = nameItem;
        this.lastMessageItem = lastMessageItem;
    }

    public int getAvatarItem() {
        return avatarItem;
    }

    public void setAvatarItem(int avatarItem) {
        this.avatarItem = avatarItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getLastMessageItem() {
        return lastMessageItem;
    }

    public void setLastMessageItem(String lastMessageItem) {
        this.lastMessageItem = lastMessageItem;
    }
}

package ir.ea2.android_materialdesign.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_materialdesign.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {

private ImageView avatar;
private TextView name;
private TextView lastMessage;

    //the itemView is template layout , by this variable we access to template layout objects
    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        //We access to context by itemView .
        avatar = itemView.findViewById(R.id.avatar_item);
        name = itemView.findViewById(R.id.name_item);
        lastMessage = itemView.findViewById(R.id.last_message_item);
    }

    //Getter for Access Element's Of Template Layout From RecyclerAdapter ;
    public ImageView getAvatar() {
        return avatar;
    }

    public TextView getName() {
        return name;
    }

    public TextView getLastMessage() {
        return lastMessage;
    }
}

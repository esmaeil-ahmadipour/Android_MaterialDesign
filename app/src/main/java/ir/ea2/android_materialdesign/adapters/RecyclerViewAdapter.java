package ir.ea2.android_materialdesign.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_materialdesign.R;
import ir.ea2.android_materialdesign.models.MessageModel;
import ir.ea2.android_materialdesign.view_holders.MessageViewHolder;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MessageViewHolder> {
   private List<MessageModel> messageModelList;

    public RecyclerViewAdapter(List<MessageModel> messageModelList) {
        this.messageModelList = messageModelList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_eight_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.getAvatar().setImageResource(messageModelList.get(position).getAvatarItem());
        holder.getName().setText(messageModelList.get(position).getNameItem());
        holder.getLastMessage().setText(messageModelList.get(position).getLastMessageItem());
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }
}

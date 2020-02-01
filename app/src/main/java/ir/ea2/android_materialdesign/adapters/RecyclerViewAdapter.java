package ir.ea2.android_materialdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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
                .inflate(R.layout.activity_eight_item2, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.getAvatar().setImageResource(messageModelList.get(position).getAvatarItem());
        holder.getName().setText(messageModelList.get(position).getNameItem());
        setViewBackgroundColor(holder.getView(),position);
        holder.getLastMessage().setText(messageModelList.get(position).getLastMessageItem());
    }

    private void setViewBackgroundColor(View view, int position) {
        if((position+1)%2 == 0){
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.colorGray));
        }else{
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(),R.color.colorWhite));

        }
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }
}

package ir.ea2.android_materialdesign.adapters;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
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
    public void onBindViewHolder(@NonNull final MessageViewHolder holder, final int position) {
        holder.getAvatar().setImageResource(messageModelList.get(position).getAvatarItem());
        holder.getName().setText(messageModelList.get(position).getNameItem());
        holder.getOptionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(holder.getView()
                                                            .getContext(), holder.getOptionView());
                popupMenu.inflate(R.menu.recycler_item_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit_menu_item:
                                Toast.makeText(holder.getView().getContext(), holder.getView()
                                        .getResources()
                                        .getString(R.string.menu_item_title_edit) + " : " + position, Toast.LENGTH_SHORT)
                                        .show();
                                break;
                            case R.id.remove_menu_item:
                                Toast.makeText(holder.getView().getContext(), holder.getView()
                                        .getResources()
                                        .getString(R.string.menu_item_title_remove) + " : " + position, Toast.LENGTH_SHORT)
                                        .show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        //Commented for Show Divider .
//        setViewBackgroundColor(holder.getView(),position);
        holder.getLastMessage().setText(messageModelList.get(position).getLastMessageItem());
    }

    private void setViewBackgroundColor(View view, int position) {
        if ((position + 1) % 2 == 0) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.colorGray));
        } else {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.colorWhite));

        }
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }
}

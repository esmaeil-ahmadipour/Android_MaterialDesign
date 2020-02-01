package ir.ea2.android_materialdesign.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.ea2.android_materialdesign.R;
import ir.ea2.android_materialdesign.models.MessageModel;
import ir.ea2.android_materialdesign.models.UserModel;
import ir.ea2.android_materialdesign.view_holders.MessageViewHolder;
import ir.ea2.android_materialdesign.view_holders.UserViewHolder;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> items = new ArrayList<>();
    public static final int TYPE_MESSAGE = 1;
    public static final int TYPE_USER = 2;

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof MessageModel) {
            return TYPE_MESSAGE;
        } else {
            return TYPE_USER;
        }
    }

    public RecyclerViewAdapter2(List<Object> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case (TYPE_MESSAGE): {
                // Any MessageViewHolder() Are RecyclerView.ViewHolder (PolyMorphism) .
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_eight_item, parent, false);
                viewHolder = new MessageViewHolder(view);
            }
            break;
            case (TYPE_USER): {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_nine_item, parent, false);
                viewHolder = new UserViewHolder(view);
            }
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = holder.getItemViewType();
        switch (viewType) {
            case (TYPE_MESSAGE): {
                showMessage(position, holder);
            }
            break;
            case (TYPE_USER): {
                showUser(position, holder);
            }
            break;
        }

    }

    private void showMessage(final int position, RecyclerView.ViewHolder holder) {
        MessageModel messageModel = (MessageModel) items.get(position);
        final MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
        messageViewHolder.getAvatar().setImageResource(messageModel.getAvatarItem());
        messageViewHolder.getName().setText(messageModel.getNameItem());
        messageViewHolder.getLastMessage().setText(messageModel.getLastMessageItem());
        messageViewHolder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(messageViewHolder.getView().getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showUser(final int position, RecyclerView.ViewHolder holder) {
        UserModel userModel = (UserModel) items.get(position);
        final UserViewHolder userViewHolder = (UserViewHolder) holder;
        userViewHolder.getAvatar().setImageResource(userModel.getItemAvatar());
        userViewHolder.getName().setText(userModel.getItemName());
        userViewHolder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(userViewHolder.getView().getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

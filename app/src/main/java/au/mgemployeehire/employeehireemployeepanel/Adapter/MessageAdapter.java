package au.mgemployeehire.employeehireemployeepanel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import au.mgemployeehire.employeehireemployeepanel.MessageActivity;
import au.mgemployeehire.employeehireemployeepanel.Model.Chat;
import au.mgemployeehire.employeehireemployeepanel.Model.ChatUsers;
import au.mgemployeehire.employeehireemployeepanel.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private Context context;
    private List<Chat> mChat;
    private String imageURL;

    //Firebase
    FirebaseUser fuser;

    public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;

    public MessageAdapter(Context context, List<Chat> mChat, String imageURL) {
        this.context = context;
        this.mChat = mChat;
        this.imageURL = imageURL;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_RIGHT){
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_right,
                    parent,false);
            return new MessageAdapter.ViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_left,
                    parent,false);
            return new MessageAdapter.ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Chat chat = mChat.get(position);
        holder.show_message.setText(chat.getMessage());

        if (imageURL.equals("default")){
            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
        }else {
            Glide.with(context).load(imageURL).into(holder.profile_image);
        }

    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView show_message;
        public ImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            show_message = itemView.findViewById(R.id.show_message);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        if (mChat.get(position).getSender().equals(fuser.getUid())){
            return MSG_TYPE_RIGHT;
        }else {
            return MSG_TYPE_LEFT;
        }
    }
}

package com.semihoksuzoglu.instagramcloneparseexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {

    private final ArrayList<String> username;
    private final ArrayList<String> userComment;
    private final ArrayList<Bitmap> userImage;
    private final Activity context;

    public PostClass(ArrayList<String> username, ArrayList<String> userComment, ArrayList<Bitmap> userImage, Activity context) {

        super(context, R.layout.costom_view, username);
        this.username = username;
        this.userComment = userComment;
        this.userImage = userImage;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.costom_view,null,true);
        TextView userNameText = customView.findViewById(R.id.custom_view_username_text);
        TextView commentText= customView.findViewById(R.id.custom_view_comment_text);
        ImageView imageView = customView.findViewById(R.id.custom_view_imageView);

        userNameText.setText(username.get(position));
        imageView.setImageBitmap(userImage.get(position));
        commentText.setText(userComment.get(position));


        return customView;
    }
}

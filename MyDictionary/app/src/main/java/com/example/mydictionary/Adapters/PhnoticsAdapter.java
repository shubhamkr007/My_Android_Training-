package com.example.mydictionary.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Phonatic;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.PhnoticviewHolder;

import java.util.List;

public class PhnoticsAdapter extends RecyclerView.Adapter<PhnoticviewHolder> {

    private Context context;
    private List<Phonatic> phonaticList;

    public PhnoticsAdapter(Context context, List<Phonatic> phonaticList) {
        this.context = context;
        this.phonaticList = phonaticList;
    }

    @NonNull
    @Override
    public PhnoticviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhnoticviewHolder(LayoutInflater.from(context).inflate(R.layout.phnotics_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhnoticviewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView_phnotic.setText(phonaticList.get(position).getText());
        holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player=new MediaPlayer();
                try{
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource("https:" + phonaticList.get(position).getAudio());
                    player.prepare();
                    player.start();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(context, "Could Not Play Audio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return phonaticList.size();
    }
}

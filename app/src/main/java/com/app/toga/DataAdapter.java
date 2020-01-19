package com.app.toga;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ListViewHolder> {

    private ArrayList<Tanaman> listTanaman;
    private Context context;

    public DataAdapter(ArrayList<Tanaman> list) {
        this.listTanaman = list;

    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.item_layout, viewGroup, false );


        return (new ListViewHolder( view ));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int posis) {


        final Tanaman tanaman = listTanaman.get( posis );

        Glide.with( holder.itemView.getContext() )
                .load( tanaman.getPoto() )
                .apply( new RequestOptions())//.override( 100 , 100 ) )
                .into( holder.potoT );


        holder.namaT.setText( tanaman.getNama());
        holder.detailT.setText( tanaman.getDetail() );

        holder.pLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, ContentLayout.class );
                intent.putExtra( "SEND_NAMA", tanaman.getNama() );
                intent.putExtra( "SEND_GAMBAR", tanaman.getPoto() );
                intent.putExtra( "SEND_CONTENT", tanaman.getDetail() );
                context.startActivity( intent );

            }
        } );


    }

    @Override
    public int getItemCount() {
        return listTanaman.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView potoT;
        TextView namaT, detailT;
        FrameLayout pLayout;

        public ListViewHolder(View itemView) {
            super( itemView );
            context = itemView.getContext();
            potoT = itemView.findViewById( R.id.image_item );
            namaT = itemView.findViewById( R.id.nama );
            detailT = itemView.findViewById( R.id.content);

            pLayout = itemView.findViewById( R.id.p_layout );
        }
    }
}
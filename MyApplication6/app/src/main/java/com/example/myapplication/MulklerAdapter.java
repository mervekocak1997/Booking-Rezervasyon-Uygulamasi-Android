package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MulklerAdapter extends RecyclerView.Adapter<MulklerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Mulkler> mulklerListe;
    private Veritabani vt;

    /*public MulklerAdapter(Context mContext, List<Mulkler> mulklerListe){
        this.mContext = mContext;
        this.mulklerListe = mulklerListe;
    }*/

    public MulklerAdapter(Context mContext, List<Mulkler> mulklerListe, Veritabani vt){
        this.mContext = mContext;
        this.mulklerListe = mulklerListe;
        this.vt = vt;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mulk_card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardTasarimTutucu holder, int position) {
   final Mulkler mulk = mulklerListe.get(position);
holder.textViewMulkBilgi.setText(mulk.getMulk_ad()+ "-"+ mulk.getMulk_adres()+"-"+ mulk.getMulk_ucret()+"-"+ mulk.getMulk_oda()+"-"+ mulk.getMulk_isitma()+"-"+ mulk.getMulk_kat()+"-"+ mulk.getMulk_aidat());
holder.imageViewNokta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(mContext, holder.imageViewNokta);
        popupMenu.getMenuInflater().inflate(R.menu.context_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_sil:
                        Snackbar.make(holder.imageViewNokta, "Mülk Silinsin mi?", Snackbar.LENGTH_SHORT)

                                .setAction("EVET", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        new MulklerDao().mulkSil(vt,mulk.getMulk_id());

                                        mulklerListe = new MulklerDao().tumMulkler(vt);
                                        notifyDataSetChanged();
                                    }
                                })

                                .show();
                        return true;
                    case R.id.action_guncelle:
alertGoster(mulk);
return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();


    }
});
    }

    @Override
    public int getItemCount() {
        return mulklerListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewMulkBilgi;
        private ImageView imageViewNokta;

        public CardTasarimTutucu(@NonNull View itemView){
            super(itemView);

            textViewMulkBilgi = itemView.findViewById(R.id.textViewMulkBilgi);
            imageViewNokta = itemView.findViewById(R.id.imageViewNokta);
        }
    } public void alertGoster(final Mulkler mulk){
        LayoutInflater layout = LayoutInflater.from(mContext);
        View tasarim = layout.inflate(R.layout.alert_tasarim, null);

        final EditText editTextAd = tasarim.findViewById(R.id.editTextAd);
        final EditText editTextTip = tasarim.findViewById(R.id.editTextTip);
        final EditText editTextAdres = tasarim.findViewById(R.id.editTextAdres);
        final EditText editTextUcret = tasarim.findViewById(R.id.editTextUcret);
        final EditText editTextOda = tasarim.findViewById(R.id.editTextOda);
        final EditText editTextİsitma = tasarim.findViewById(R.id.editTextİsitma);
        final EditText editTextKat = tasarim.findViewById(R.id.editTextKat);
        final EditText editTextAidat = tasarim.findViewById(R.id.editTextAidat);

        editTextAd.setText(mulk.getMulk_ad());
        editTextTip.setText(mulk.getMulk_tip());
        editTextAdres.setText(mulk.getMulk_adres());
        editTextUcret.setText(mulk.getMulk_ucret());
        editTextİsitma.setText(mulk.getMulk_isitma());
        editTextKat.setText(mulk.getMulk_kat());
        editTextOda.setText(mulk.getMulk_oda());
        editTextAidat.setText(mulk.getMulk_aidat());

        AlertDialog.Builder ad = new AlertDialog.Builder(mContext);
        ad.setTitle("Mülk Guncelle");
        ad.setView(tasarim);
        ad.setPositiveButton("Guncelle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String mulk_ad = editTextAd.getText().toString().trim();
                String mulk_tip = editTextTip.getText().toString().trim();
                String mulk_adres = editTextAdres.getText().toString().trim();
                String mulk_ucret = editTextUcret.getText().toString().trim();
                String mulk_oda = editTextOda.getText().toString().trim();
                String mulk_isitma = editTextİsitma.getText().toString().trim();
                String mulk_kat = editTextKat.getText().toString().trim();
                String mulk_aidat = editTextAidat.getText().toString().trim();

                //aldığım veriy tekrardan çekmek isteseydim
                // mulklerArrayList = new MulklerDao().tumMulkler(vt);
                // adapter = new MulklerAdapter(AnasayfaActivity.this, mulklerArrayList);
                //rv.setAdapter(adapter);

                new MulklerDao().mulkGuncelle(vt,mulk.getMulk_id(),mulk_ad,mulk_tip,mulk_adres,mulk_ucret,mulk_oda,mulk_kat,mulk_aidat,mulk_isitma);
                mulklerListe = new MulklerDao().tumMulkler(vt);
                notifyDataSetChanged();
                 }
        });

        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        ad.create().show();


    }
}

package io.github.thesunilvarma.pwa_c;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private final ArrayList<String> mAppOpenLink;

    private ArrayList<String> mAppName;
    public static ArrayList<String> mAppDescription;
    private ArrayList<String> mAppLogo;
    // private ArrayList<String> mAppDot = new ArrayList<>();
    private Context mContext;
  //  private String sm = openApp();


//    private void createShortcut(final int position) {
//
//
////        ShortcutManagerCompat shortcutManager = null;
////        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
////            shortcutManager = mContext.getSystemService(ShortcutManagerCompat.class);
////        }
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////            if (shortcutManager != null) {
////                if (shortcutManager.isRequestPinShortcutSupported()) {
////                    ShortcutInfo shortcut = new ShortcutInfo.Builder(mContext, ""+mAppLogo.get(position))
////                            .setShortLabel("Demo")
////                            .setLongLabel("Open the Android Docu")
////                            .setIcon(Icon.createWithResource(mContext, R.drawable.andi))
////                            .setIntent(new Intent(Intent.ACTION_VIEW,
////                                    Uri.parse(MainActivity.mAppLogos.get(position))))
////                            .build();
////
////                    shortcutManager.requestPinShortcut(shortcut, null);
//            //    if (ShortcutManagerCompat.isRequestPinShortcutSupported(mContext)) {
//
//
//        ImageView imageView=null;
//        Glide.with(mContext).load("http://goo.gl/gEgYUd").into(imageView);
//        final int drawable=imageView.getImageAlpha();
//
//
//        Runnable r = new Runnable() {
//            @Override
//            public void run(){
//                Toast.makeText(mContext, "Pinned shortcuts are not supported!", Toast.LENGTH_SHORT).show();
//                ShortcutInfoCompat shortcut1 = new ShortcutInfoCompat.Builder(mContext, ""+mAppLogo.get(position))
//                        .setShortLabel("Demo")
//                        .setLongLabel("Open the Android Docu")
//                        .setIcon(IconCompat.createWithResource(mContext, drawable))
//                        .setIntent(new Intent(Intent.ACTION_VIEW,
//                                Uri.parse(MainActivity.mAppLogos.get(position))))
//                        .build();
//
//                ShortcutManagerCompat.requestPinShortcut(mContext,shortcut1, null); //<-- put your code in here.
//            }
//        };
//
//        Handler h = new Handler();
//        h.postDelayed(r, 5000);
//
//
//
//
//
//           //     }
//                }
//       // }
////    }
////}

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mAppName, ArrayList<String> mAppDescription, ArrayList<String> mAppLogo, ArrayList<String> mAppOpenLink) {
        this.mAppName = mAppName;
        this.mAppDescription = mAppDescription;
        this.mAppLogo = mAppLogo;
        this.mAppOpenLink = mAppOpenLink;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder : called.");

        RequestOptions options = new RequestOptions();
        options.centerInside();
        Glide.with(mContext)
                .asBitmap()
                .load(mAppLogo.get(position)).apply(options)
                .into(holder.appLogo);
        holder.appName.setText(mAppName.get(position));
        holder.appDescription.setText(mAppDescription.get(position));
        holder.appCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick: clicked on: " + mAppName.get(position));
                openApp(position);

                Toast.makeText(mContext,mAppName.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        holder.appLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick: clicked on: " + mAppName.get(position));
                openApp(position);

                Toast.makeText(mContext,mAppName.get(position)+"img",Toast.LENGTH_SHORT).show();
            }
        });
        holder.appDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                final Intent intentOpen = new Intent(mContext,AppOpenActivity.class);


                //Display Option Menu

                PopupMenu popupMenu = new PopupMenu(mContext,holder.appDot);
                popupMenu.inflate(R.menu.cardmenu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.optopen:

//                                intentOpen.putExtra("appName",mAppLogo.get(position));
//                                mContext.startActivity(intentOpen);

                             //   createShortcut(position);
                                openApp(position);

                                Toast.makeText(mContext,""+MainActivity.mAppLogos.get(position),Toast.LENGTH_SHORT).show();
                            break;
                            case R.id.optcreatehs:

                             //   createShortcut(position);
                                Toast.makeText(mContext,""+position,Toast.LENGTH_SHORT).show();
                            break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAppName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView appName;
        public TextView appDescription;
        public CircleImageView appLogo;
        public TextView appDot;
        public ConstraintLayout  parentlayout;
        public CardView appCard;

        public ViewHolder(View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.appName);
            appDescription = itemView.findViewById(R.id.appDescription);
            appLogo = itemView.findViewById(R.id.appLogo);
            parentlayout = itemView.findViewById(R.id.parentLayout);
            appCard = itemView.findViewById(R.id.card);
            appDot = itemView.findViewById(R.id.appDot);

        }

    }

    public final int openApp(int position){
     //   Toast.makeText(mContext,"Opening Ola",Toast.LENGTH_SHORT).show();



//        final CustomTabsIntent intent = new CustomTabsIntent.Builder().build();
//        final String url = mAppOpenLink.get(position);
//        intent.intent.setPackage("com.android.chrome");
//        intent.launchUrl(mContext, Uri.parse(url));
        Intent intent = new Intent(mContext, webview.class);
        //String posi = null;
        intent.putExtra("posi", position);
        mContext.startActivity(intent);
        return position;

    }

    public void setSearchOperation(List<String> newlist){
        mAppName = new ArrayList<>();
        mAppName.addAll(newlist);
        notifyDataSetChanged();

    }


}

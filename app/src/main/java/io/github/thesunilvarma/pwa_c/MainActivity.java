package io.github.thesunilvarma.pwa_c;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Toolbar toolbar;
    android.widget.SearchView searchView;

    //vars
    public static ArrayList<String> mAppNames = new ArrayList<>();
    public static ArrayList<String> mAppLogos = new ArrayList<>();
    public static ArrayList<String> mAppOpenLink = new ArrayList<>();
    public static ArrayList<String> mAppDescription = new ArrayList<>();
    private String c_redirectlink = "https://linksredirect.com/?pub_id=34482CL31100";
    private String c_subid = "&subid=androidapp";
    private String c_https = "&source=linkkit&url=https%3A%2F%2F";
    private String v_link = "https://redirect.viglink.com?key=e95c5378701a76cd68a4e7ccbea420a6&u=https%3A%2F%2F";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: started.");
        toolbar=findViewById(R.id.search);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initImageLogoBitmaps();

    }

    private void initImageLogoBitmaps(){
        Log.d(TAG,"initImageLogoBitmaps: preparing bitmaps.");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2191/medium/Adidas_%282%29.png?1493896535");
        mAppNames.add("Adidas");
        mAppDescription.add("Adidas");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"shop.adidas.co.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/207/medium/airtel.png?1517827681");
        mAppNames.add("Airtel Online Recharge");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.airtel.in%2Fprepaid-recharge");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2589/medium/Ajio.png?1516080211");
        mAppNames.add("Ajio");
        mAppDescription.add("Ajio");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.ajio.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/763/medium/AliExpress.png?1489062038");
        mAppNames.add("AliExpress");
        mAppDescription.add("AliExpress");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.aliexpress.com");

        mAppLogos.add("https://cdn2.mhpbooks.com/2016/06/Amazon-icon.png");
        mAppNames.add("Amazon");
        mAppDescription.add("Amazon Wale");
        mAppOpenLink.add("https://amzn.to/2MkmLjc");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/757/medium/bata.png?1362365679");
        mAppNames.add("Bata");
        mAppDescription.add("Bata");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"bata.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2564/medium/beardo.png?1497000496");
        mAppNames.add("Beardo");
        mAppDescription.add("Beardo");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.beardo.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/803/medium/Beyond-Enough.png?1491197461");
        mAppNames.add("Beyond Enough");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.beyondenough.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2172/medium/Biba.png?1516178938");
        mAppNames.add("Biba");
        mAppDescription.add("Biba");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.biba.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/18/medium/Big-Rock.png?1493898273");
        mAppNames.add("BigRock");
        mAppDescription.add("BigRock");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.bigrock.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/18/medium/Big-Rock.png?1493898273");
        mAppNames.add("BigRock");
        mAppDescription.add("BigRock");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.bigrock.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2401/medium/bb_logo.png?1449479807");
        mAppNames.add("Bigbasket");
        mAppDescription.add("Bigbasket");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.bigbasket.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3560/medium/bing.png?1523019714");
        mAppNames.add("Bing Ads");
        mAppDescription.add("Bing Ads");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"advertise.bingads.microsoft.com%2Fen-in%2Fh%2Fa%2Faffiliate");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/20/medium/Bluestone.png?1489126953");
        mAppNames.add("Bluestone");
        mAppDescription.add("Bluestone");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.bluestone.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3129/medium/book-my-show.png?1493139632");
        mAppNames.add("Bookmyshow");
        mAppDescription.add("Bookmyshow");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"in.bookmyshow.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/806/medium/Candere.png?1516181054");
        mAppNames.add("Candere");
        mAppDescription.add("Candere");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.candere.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3433/medium/Cashify.png?1511876834");
        mAppNames.add("Cashify");
        mAppDescription.add("Cashify");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.cashify.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3430/medium/charles.png?1511519485");
        mAppNames.add("Charles & Keith");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.charleskeith.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/1809/medium/Chumbak.png?1489127100");
        mAppNames.add("Chumbak");
        mAppDescription.add("Chumbak");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.chumbak.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/29/medium/cleartrip_logo_medium.gif?1342766947");
        mAppNames.add("Cleartrip");
        mAppDescription.add("Cleartrip");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.cleartrip.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2206/medium/Clovia.png?1516182504");
        mAppNames.add("Clovia");
        mAppDescription.add("Clovia");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.clovia.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2567/medium/download.png?1463142913");
        mAppNames.add("Coolwinks");
        mAppDescription.add("Coolwinks");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.coolwinks.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/201/medium/Croma_Retail.png?1493190022");
        mAppNames.add("Croma Retail");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.croma.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3669/medium/Curefit.png?1532609634");
        mAppNames.add("Curefit");
        mAppDescription.add("Curefit");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.cure.fit%2Feat");


        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/229/medium/dailyobjects.png?1498647455");
        mAppNames.add("DailyObjects");
        mAppDescription.add(" ");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.dailyobjects.com");


        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3544/medium/dresslily.png?1521715767");
        mAppNames.add("DressLily");
        mAppDescription.add("DressLily");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.dresslily.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3344/medium/eJohri.png?1505365013");
        mAppNames.add("eJohri");
        mAppDescription.add("eJohri");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.ejohri.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3450/medium/eventshigh.png?1512713659");
        mAppNames.add("Events High");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.eventshigh.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/1614/medium/download.....png?1481723220");
        mAppNames.add("Exclusive Lane");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.exclusivelane.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/42/medium/Expedia-India.png?1489138143");
        mAppNames.add("Expedia India");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.expedia.co.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3179/medium/Expert.png?1494854531");
        mAppNames.add("ExpertRating");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.expertrating.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2487/medium/fassos.png?1496897999");
        mAppNames.add("Faasos");
        mAppDescription.add("Faasos");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"order.faasos.io");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/1663/medium/FabIndia_PNG.png?1490774647");
        mAppNames.add("Fabindia");
        mAppDescription.add("Fabindia");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.fabindia.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/53/medium/Ferns-N-Petals.png?1501826142");
        mAppNames.add("Fernsnpetals");
        mAppDescription.add("Fernsnpetals");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.fnp.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/49/medium/Firstcry.png?1489139795");
        mAppNames.add("Firstcry");
        mAppDescription.add("Firstcry");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.firstcry.com");

        mAppLogos.add("https://image.winudf.com/v2/image/Y29tLndGbGlwa2FydExpdGVfNjA4OTIyMF9pY29uXzE1MTI1NzEwMjFfMDY4/icon.png?w=170&fakeurl=1&type=.png");
        mAppNames.add("Flipkart");
        mAppDescription.add("The Big Billion Day");
        mAppOpenLink.add("https://www.flipkart.com/?affid=onehack4a");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/889/medium/Send_Flowers_Online___Online_Flowers_Delivery___FlowerAura.png?1374824302");
        mAppNames.add("Flower Aura");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.floweraura.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/187/medium/foodpand.png?1502888078");
        mAppNames.add("Foodpanda");
        mAppDescription.add("Foodpanda");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.foodpanda.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/493/medium/GoDaddy.png?1513753648");
        mAppNames.add("GoDaddy");
        mAppDescription.add("GoDaddy");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"in.godaddy.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2619/medium/gofynd.png?1490942895");
        mAppNames.add("Gofynd");
        mAppDescription.add("Gofynd");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.gofynd.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2339/medium/Hp.png?1488869836");
        mAppNames.add("HP shopping");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.hpshopping.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/847/medium/Healthkart.png?1490272752");
        mAppNames.add("HealthKart");
        mAppDescription.add("HealthKart");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.healthkart.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3627/medium/Internshala.png?1527575974");
        mAppNames.add("Internshala");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"trainings.internshala.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/80/medium/jabong.jpg?1427448798");
        mAppNames.add("Jabong");
        mAppDescription.add("Jabong");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.jabong.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/1911/medium/KFC_Online_delivery_Order_KFC_Online_India_Offers__discounts_and_coupons.png?1402055287");
        mAppNames.add("KFC Delivery");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"online.kfc.co.in%2Foffer%2Flisting");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/91/medium/Lenskart.png?1490766937");
        mAppNames.add("Lenskart");
        mAppDescription.add("Lenskart");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.lenskart.com%2Ftry-at-home%2F");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/354/medium/Limeroad.png?1513409313");
        mAppNames.add("Limeroad");
        mAppDescription.add("LimeRoad");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.limeroad.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/93/medium/Make_my_trip.png?1503474625");
        mAppNames.add("Makemytrip");
        mAppDescription.add("Makemytrip");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.makemytrip.com%2Fflights");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/765/medium/MCDonalds.png?1504500381");
        mAppNames.add("McDonalds");
        mAppDescription.add("McDonalds");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.mcdelivery.co.in");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2585/medium/Medlife-orange-logo-final.png?1512800263");
        mAppNames.add("Medlife");
        mAppDescription.add("Medlife");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"m.medlife.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/1887/medium/mobikwik_logo.png?1499865596");
        mAppNames.add("Mobikwik");
        mAppDescription.add("Mobikwik");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.mobikwik.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/916/medium/Musafir.png?1488871532");
        mAppNames.add("Musafir");
        mAppDescription.add("Musafir");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"in.musafir.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/101/medium/Myntra.png?1491896562");
        mAppNames.add("Myntra");
        mAppDescription.add("Myntra");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.myntra.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2351/medium/Netmeds.com__Online_Pharmacy_in_India_%E2%80%93_Buy_Medicines_Online.png?1442819652");
        mAppNames.add("Netmeds");
        mAppDescription.add("Netmeds");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.netmeds.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/1402/medium/nike.jpg?1387337588");
        mAppNames.add("Nike Store");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.nike.com%2Fin%2Fen_gb%2F");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3021/medium/Salebhai.png?1485252125");
        mAppNames.add("Salebhai");
        mAppDescription.add("Salebhai");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.salebhai.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/152/medium/Shopclues.png?1493899872");
        mAppNames.add("ShopClues");
        mAppDescription.add("ShopClues");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.shopclues.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/119/medium/SnapDeal.png?1520340610");
        mAppNames.add("Snapdeal");
        mAppDescription.add("Snapdeal");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.snapdeal.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/2194/medium/Swiggy.png?1490352043");
        mAppNames.add("Swiggy");
        mAppDescription.add("Swiggy");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.swiggy.com");

        mAppLogos.add("https://static.pelando.com.br/live/threads/thread_large/default/182608_1.jpg");
        mAppNames.add("Udemy");
        mAppDescription.add("Udemy");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.udemy.com");

        mAppLogos.add("https://cdn0.cuelinks.com/campaigns/3233/medium/NEW_LOGO_MY_VISHAL.jpg?1518522012");
        mAppNames.add("Vishal Megamart");
        mAppDescription.add("");
        mAppOpenLink.add(c_redirectlink+c_subid+c_https+"www.myvishal.com");

        mAppLogos.add("https://logos-download.com/wp-content/uploads/2016/06/Zomato_logo.png");
        mAppNames.add("Zomato");
        mAppDescription.add("Zomato");
        mAppOpenLink.add(v_link+"zomato.com");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init RecyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recyclerView_main);

//        Collections.sort(mAppNames, new Comparator<AppName>() {
//            @Override
//            public int compare(AppName mApp, AppName mApp1) {
//                return mApp.compareTo(mApp1.mAppNames);
//            }
//        });
//          RecyclerViewAdapter RvA = new RecyclerViewAdapter(getApplicationContext(),mAppNames,mAppDescription,mAppLogos,mAppOpenLink);
//        Collections.sort(mAppNames);
//        Collections.sort(mAppDescription);
//        Collections.sort(mAppLogos);
//        Collections.sort(mAppOpenLink);
//        RvA.notifyDataSetChanged();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mAppNames,mAppDescription,mAppLogos,mAppOpenLink);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this,"ooooooooooooooo",Toast.LENGTH_SHORT).show();
        getMenuInflater().inflate(R.menu.search,menu);
        SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView=(android.widget.SearchView)menu.findItem(R.id.search);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search for Anything");
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                String userInput = s.toLowerCase();
                List<String> newList = new ArrayList<>();
                for (String name : mAppNames){

                    if (name.toLowerCase().contains(userInput)){
                        newList.add(name);
                    }
                }
                RecyclerViewAdapter RvA = new RecyclerViewAdapter(getApplicationContext(),mAppNames,mAppDescription,mAppLogos,mAppOpenLink);
                RvA.setSearchOperation(newList);
                return true;
            }
        });

        return true;
    }

//    public void submit(View view) {
//        Intent intent = new Intent(this, webview.class);
//        intent.putExtra("submit", "");
//        this.startActivity(intent);
//    }
}

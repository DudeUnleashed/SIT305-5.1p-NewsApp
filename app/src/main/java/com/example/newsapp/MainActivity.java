package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerTopStories;
    RecyclerView recyclerNews;
    RecyclerView.LayoutManager layoutManagerTopStories, layoutManagerNews;
    ArrayList<NewsDataModel> relatedNewsList;
    ArrayList<NewsDataModel> topStoriesList;
    ArrayList<NewsDataModel> newsList;
    TopStoriesAdapter topStoriesAdapter;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerTopStories = findViewById(R.id.recyclerTopStories);
        recyclerNews = findViewById(R.id.recyclerNews);

        //int image1 = this.getResources().getIdentifier("image1", "drawable", this.getPackageName());
        int image2 = this.getResources().getIdentifier("image2", "drawable", this.getPackageName());
        int image3 = this.getResources().getIdentifier("image3", "drawable", this.getPackageName());
        int image4 = this.getResources().getIdentifier("image4", "drawable", this.getPackageName());
        //int image5 = this.getResources().getIdentifier("image5", "drawable", this.getPackageName());
        int image6 = this.getResources().getIdentifier("image6", "drawable", this.getPackageName());
        int image7 = this.getResources().getIdentifier("image7", "drawable", this.getPackageName());
        //int image8 = this.getResources().getIdentifier("image8", "drawable", this.getPackageName());
        int image9 = this.getResources().getIdentifier("image9", "drawable", this.getPackageName());
        int image10 = this.getResources().getIdentifier("image10", "drawable", this.getPackageName());
        int image11 = this.getResources().getIdentifier("image11", "drawable", this.getPackageName());

        //create related news list for later
        relatedNewsList = new ArrayList<>();
        relatedNewsList.add(new NewsDataModel("World's Largest Pizza Made in Italy", "A group of pizza chefs in Italy have set a new world record for the largest pizza ever made. The pizza, which measured over 3,000 square feet, was cooked in a giant wood-fired oven and took over 10 hours to prepare.",  image11, relatedNewsList));
        relatedNewsList.add(new NewsDataModel("Robot Waiters Introduced at a Restaurant in Japan", "A restaurant in Japan has introduced robot waiters to serve customers. The robots, which are equipped with cameras and sensors, can take orders, serve food and drinks, and even engage in basic conversation with customers.",  image2, relatedNewsList));
        relatedNewsList.add(new NewsDataModel("New Study Shows Benefits of Meditation on Brain Health", "A new study has shown that regular meditation can improve brain health and cognitive function. The study, which involved over 1,000 participants, found that those who practiced meditation for at least 20 minutes a day had better memory, focus, and attention than those who did not.",  image3, relatedNewsList));
        relatedNewsList.add(new NewsDataModel("Amazon Announces Plans to Deliver Packages by Drone", "Amazon has announced plans to deliver packages to customers using drones. The drones, which are equipped with cameras and sensors, can deliver packages within a 10-mile radius of Amazon's fulfillment centers, making it faster and more efficient than traditional delivery methods.",  image4, relatedNewsList));

        //create top stories list
        topStoriesList = new ArrayList<>();
        topStoriesList.add(new NewsDataModel("Amazon to Acquire MGM for $8.45 Billion", "NASA's Mars helicopter, Ingenuity, has completed its fourth successful flight on the red planet. The small helicopter made history last month as the first aircraft to achieve powered, controlled flight on another planet.",  image2, relatedNewsList));
        topStoriesList.add(new NewsDataModel("NASA's Mars Helicopter Completes Fourth Successful Flight", "The United Nations has warned that the world is facing a \"catastrophic\" water crisis, with more than 2 billion people lacking access to safe drinking water. The organization has called for urgent action to address the issue, including investment in infrastructure and policies to improve water management.",  image11, relatedNewsList));
        topStoriesList.add(new NewsDataModel("UN Warns of \"Catastrophic\" Global Water Crisis", "Amazon has announced that it will acquire MGM, the movie studio behind the James Bond franchise, for $8.45 billion. The move is expected to bolster Amazon's streaming service, Prime Video, with a library of popular films and TV shows.",  image9, relatedNewsList));
        topStoriesList.add(new NewsDataModel("Facebook Launches Clubhouse Competitor, \"Live Audio Rooms\"", "Facebook has announced the launch of \"Live Audio Rooms,\" a feature that allows users to host live audio conversations. The move is seen as a direct competitor to Clubhouse, the audio-only social media app that has gained popularity in recent months.",  image4, relatedNewsList));
        topStoriesList.add(new NewsDataModel("Jeff Bezos Steps Down as Amazon CEO, Andy Jassy Takes Over", "Jeff Bezos, the founder of Amazon, has stepped down as CEO of the company after 27 years at the helm. Bezos will be replaced by Andy Jassy, who previously headed up Amazon's cloud computing division.",  image3, relatedNewsList));
        topStoriesList.add(new NewsDataModel("Apple Releases AirTag Tracking Device", "Apple has released its long-awaited AirTag tracking device, which allows users to locate lost items using the company's Find My app. The small, round device can be attached to keys, wallets, and other objects, and uses Bluetooth technology to communicate with nearby Apple devices.",  image10, relatedNewsList));

        //create top news list
        newsList = new ArrayList<>();
        newsList.add(new NewsDataModel("European Super League Collapses", "The proposed European Super League, a new competition featuring some of the biggest football clubs in Europe, collapsed within days of its announcement in April. The move was met with widespread opposition from fans, players, and even politicians, who argued that it would damage the existing football structure.",  image3, relatedNewsList));
        newsList.add(new NewsDataModel("SpaceX Launches Crew-2 Mission to International Space Station", "SpaceX launched its Crew-2 mission to the International Space Station in April, with a crew of four astronauts aboard the Dragon spacecraft. The mission is the third crewed flight for SpaceX, which is working to establish itself as a major player in the space industry.",  image6, relatedNewsList));
        newsList.add(new NewsDataModel("Scientists Discover New Species of Whale in the Arctic", "A team of marine biologists has discovered a new species of whale in the Arctic Ocean. The whale, which has been named the Arctic Blue Whale, is the largest animal ever discovered and is estimated to weigh up to 250,000 pounds.",  image2, relatedNewsList));
        newsList.add(new NewsDataModel("Apple Announces Revolutionary New Health Monitoring Device", "Apple has announced a new health monitoring device that can detect a range of medical conditions, including heart disease, diabetes, and cancer. The device, which is worn like a smartwatch, uses advanced sensors and artificial intelligence to analyze data and provide personalized health recommendations.",  image7, relatedNewsList));
        newsList.add(new NewsDataModel("Uber Launches Self-Driving Car Service in Major Cities", "Ride-hailing company Uber has launched a self-driving car service in several major cities around the world. The service, which uses autonomous vehicles, is expected to revolutionize the transportation industry and reduce the number of accidents caused by human error.",  image10, relatedNewsList));
        newsList.add(new NewsDataModel("Elon Musk Reveals Plans to Colonize Mars by 2050", "Tesla and SpaceX CEO Elon Musk has revealed plans to colonize Mars by 2050, with the ultimate goal of making the planet a backup for human civilization. The plan involves launching thousands of spacecraft to transport people and resources to Mars, where they will establish a self-sustaining colony.",  image4, relatedNewsList));

        //make horizontal
        layoutManagerTopStories = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topStoriesAdapter = new TopStoriesAdapter(this, topStoriesList);
        recyclerTopStories.setAdapter(topStoriesAdapter);
        recyclerTopStories.setLayoutManager(layoutManagerTopStories);

        //make horizontal
        layoutManagerNews = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
        newsAdapter = new NewsAdapter(this, newsList);
        recyclerNews.setAdapter(newsAdapter);
        recyclerNews.setLayoutManager(layoutManagerNews);


    }

    public ArrayList<NewsDataModel> getRelatedNews() {
        return relatedNewsList;
    }

    public void setAdapterClickable(boolean clickable) {
        newsAdapter.setClickable(clickable);
        topStoriesAdapter.setClickable(clickable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAdapterClickable(true);

    }
}
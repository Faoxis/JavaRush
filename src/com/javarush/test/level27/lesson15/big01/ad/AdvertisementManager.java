package com.javarush.test.level27.lesson15.big01.ad;
import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videos = storage.list();
        List<Advertisement> advertisementsReadyToWatch = new ArrayList<>();

        Collections.sort(videos, new Comparator<Advertisement>() {
            int getPriceOfSecond(Advertisement advertisement) {
                return (int) (1000 * advertisement.getAmountPerOneDisplaying() / advertisement.getDuration());
            }

            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = getPriceOfSecond(o1) - getPriceOfSecond(o2);
                return result;
            }
        });

        int advertisementTime = timeSeconds;
        for (Advertisement advertisement : storage.list()) {
            if ((int) advertisement.getAmountPerOneDisplaying() < advertisementTime) {
                int counter = 0;
//                while (advertisement.getAmountPerOneDisplaying() < advertisementTime && advertisement. > counter) {
//
//                    counter++;
//
//                }
            }
        }
        System.out.println("------------------------");

    }

    public static void main(String[] args) {
        AdvertisementManager advertisementManager = new AdvertisementManager(120);
        printAdvertisementList(advertisementManager);
        System.out.println("---------------------------------------------------");
        advertisementManager.processVideos();
        printAdvertisementList(advertisementManager);
    }

    public static void printAdvertisementList(AdvertisementManager advertisementManager) {
        for (Advertisement advertisement : advertisementManager.storage.list()) {
            System.out.println(advertisement.getName() + " " +
                    advertisement.getDuration() + " " +
                    advertisement.getAmountPerOneDisplaying());
        }
    }

}

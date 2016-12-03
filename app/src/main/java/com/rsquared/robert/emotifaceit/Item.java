package com.rsquared.robert.emotifaceit;

/**
 * Created by emesh on 12/3/2016.
 */

public class Item {
    String name;
    int emoticonImage;

    public Item(String name, int emoticonImage)
    {
        this.emoticonImage=emoticonImage;
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public int getEmoticonImage()
    {
        return emoticonImage;
    }
}

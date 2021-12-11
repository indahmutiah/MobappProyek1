package com.example.bejostorelogin;

public class produk {
    private int image;
    private String name;
    private int qty;
    private int price;

    public produk(int image, String name, int qty, int price) {
        this.image = image;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public int getImages() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }
}

package com.gmail.runkevich8.data.database;


import java.io.IOException;

public interface AssetsReader {
    String readFromAssets(String fileName) throws IOException;
}

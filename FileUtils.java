package com.example.notepad;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileUtils {
    public static void writeTxtToFile(String content, String filePath, String fileName)
    {
        makeFilePath(filePath, fileName);
        String strFilePath = filePath+fileName;
        String strContent = content+"\r\n";
        try
        {
            File file = new File(strFilePath);
            if(!file.exists())
            {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(content.getBytes());
            raf.close();
        } catch (Exception e)
        {
            Log.e("TestFile", "Error on writeFile: "+ e);
        }
    }

    public static File makeFilePath(String filePath, String fileName)
    {
        File file = null;
        makeRootDirectory(filePath);
        try
        {
            file = new File(filePath+fileName);
            if(!file.exists())
            {
                file.createNewFile();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return file;
    }

    public static void makeRootDirectory(String filePath)
    {
        File file = null;
        try
        {
            file = new File(filePath);
            if(!file.exists())
            {
                file.mkdir();
            }
        }
        catch(Exception e)
        {
            Log.i("error", e+"");
        }
    }


}

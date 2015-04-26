package main.java.test.app;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;

public class SiteList
{
    private JList siteList = new JList();
    private File file;
    private Object[] listData;

    public SiteList(String fileName)
    {
        file = new File(fileName);
        getListDataFromFile(file);
        siteList.setListData(listData);
    }

    public void getListDataFromFile(File file)
    {
        LinkedList list = new LinkedList();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String site = br.readLine();
            while (site != null)
            {
                list.add(site);
                site = br.readLine();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        listData = list.toArray();
    }

    public Object[] getListData()
    {
        return listData;
    }

    public JList getJList()
    {
        return siteList;
    }
}

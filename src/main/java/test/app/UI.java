package main.java.test.app;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class UI implements Runnable
{
    private JFrame frame;
    private JPanel panel;
    private JPanel innerPanel;
    private SiteList siteList;
    private JButton button;
    private JTextPane textPane;

    public JTextPane getTextPane()
    {
        return textPane;
    }

    @Override
    public void run()
    {
        createAndShowUI();
    }

    private void createAndShowUI()
    {
        setUpFrame();
        setUpPanels();
        setUpButtons();
        setUpHttpAvailabilityPanel();
        setUpTextPane();
        frame.setVisible(true);
    }

    private void setUpTextPane()
    {
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setOpaque(false);
        panel.add(textPane, BorderLayout.CENTER);
    }

    private void setUpHttpAvailabilityPanel()
    {
        siteList = new SiteList("siteList.txt");
        JScrollPane scrollPane = new JScrollPane(siteList.getJList());

        innerPanel = new JPanel();
        innerPanel.setLayout(new BorderLayout());

        panel.add(innerPanel, BorderLayout.WEST);

        innerPanel.add(scrollPane, BorderLayout.CENTER);
        innerPanel.add(button, BorderLayout.SOUTH);
    }

    private void setUpButtons()
    {
        button = new JButton("Check availability");
        button.setMaximumSize(new Dimension(300, 300));
        button.addActionListener(new ButtonListener(this));
    }

    private void setUpPanels()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        menuBar.add(new JMenu("About"));
        frame.setJMenuBar(menuBar);
        final JTabbedPane tabbedPane = new JTabbedPane();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        tabbedPane.addTab("Http availability", panel);
        Arrays.asList(new String[]{"Emails", "SMTP-servers", "Templates", "Timers"})
                .forEach(i -> tabbedPane.addTab(i, new JPanel()));
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        frame.add(tabbedPane);
    }

    private void setUpFrame()
    {
        frame = new JFrame("TestApp");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 600);
    }

    public SiteList getSiteList()
    {
        return siteList;
    }
}

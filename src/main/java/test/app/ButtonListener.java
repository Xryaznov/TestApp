package main.java.test.app;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener
{
    private UI ui;

    public ButtonListener(UI ui)
    {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Check availability"))
        {
            for (Object obj : ui.getSiteList().getListData())
            {
                String site = String.valueOf(obj);
                int responseCode = HttpChecker.check(site);
                StyledDocument doc = ui.getTextPane().getStyledDocument();
                try
                {
                    if (responseCode == 200)
                    {
                        doc.insertString(0, site + " is available\n", null);
                    } else
                    {
                        doc.insertString(0, site + " is unavailable\n", null);
                    }
                } catch (BadLocationException badLocationException)
                {
                    badLocationException.printStackTrace();
                }
            }
        }
    }
}

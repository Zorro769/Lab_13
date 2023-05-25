import java.awt.*;
import java.awt.event.*;

public class MenuWindow extends Frame implements ActionListener, ItemListener {
    class MyEventWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
        }
    }

    String message, itemMessage;
    public void actionPerformed(ActionEvent e) {
        if (message.length() > 70) message = "Kоманди меню:";
        String actionStr = (String) e.getActionCommand();
        if (actionStr.equals("Правопис")) message += "->Правопис";
        else if (actionStr.equals("Статистика")) message += "->Статистика";
        else if (actionStr.equals("Мова")) message += "->Мова";
        else if (actionStr.equals("Вибір мови")) message += "->Вибір мови";
        else if (actionStr.equals("Переклад")) message += "->Переклад";
        else if (actionStr.equals("Розставлення переносів")) message += "->Розставлення переносів";
        repaint();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) itemMessage = "Рядок меню: ТАК";

        else itemMessage = "Рядок меню: HI";
        repaint();
    }

    public void paint(Graphics g) {
        if (message != null && itemMessage != null) {
            g.drawString(message, 10, 300);
            g.drawString(itemMessage, 10, 320);
        }
    }
    void makeMenu() {
        MenuBar WindowMenuBar = new MenuBar();
        setMenuBar(WindowMenuBar);
        Menu format = new Menu("Формат");;
        WindowMenuBar.add(format);

        Menu service = new Menu("Сервіс");
        MenuItem spell;
        spell = new MenuItem("Правопис");
        spell.addActionListener(this);
        service.add(spell);

        service.addSeparator();

        CheckboxMenuItem stat = new CheckboxMenuItem("Статистика");
        stat.addItemListener(this);
        service.add(stat);

        Menu lang = new Menu("Мова");
        MenuItem choosLang,trans,hyph;

        choosLang = new MenuItem("Вибір мови");
        choosLang.addActionListener(this);
        lang.add(choosLang);

        trans = new MenuItem("Переклад");
        trans.addActionListener(this);
        lang.add(trans);

        hyph = new MenuItem("Розставлення переносів");
        hyph.addActionListener(this);
        lang.add(hyph);

        lang.addActionListener(this);
        service.add(lang);
        WindowMenuBar.add(service);

        Menu table = new Menu("Таблиця");
        table.addActionListener(this);

        WindowMenuBar.add(table);
    }

    public MenuWindow(String name) {
        super(name);
        setSize(500, 400);
        setVisible(true);
        addWindowListener(new MyEventWindowAdapter());
        message = "Kоманди меню: ";
        makeMenu();
    }

}

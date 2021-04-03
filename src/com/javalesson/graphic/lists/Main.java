package com.javalesson.graphic.lists;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    }






    public static void createUI(){
        JFrame frame = new JFrame("Пример списка");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(1, 3));
        setOne(panel);
        setTwo(panel);
        frame.setContentPane(panel);
        frame.setSize(600, 100);
        frame.setLocation(2500, 100);
        frame.setVisible(true);
    }


    private static void setOne(JPanel panel) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");
        list.add("two");
        list.add("three");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listOne = new JList<>(listModel);


        JScrollPane scrollPane = new JScrollPane(listOne);
        listOne.setLayoutOrientation(JList.VERTICAL);
        listOne.setCellRenderer(new MyCellRender());
        listModel.addAll(list);

        
        panel.add(scrollPane);
        listOne.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(listModel.get(e.getFirstIndex()));
            }
        });
    }


    public static void setTwo(JPanel panel) {
        List<String> list = new ArrayList<>();
        list.add("example");
        list.add("example 2");
        list.add("example 3");
        list.add("example 4");
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addAll(list);
        JComboBox comboBox = new JComboBox(comboBoxModel);
        comboBox.setSelectedIndex(0);
        panel.add(comboBox);


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox.getSelectedIndex());
            }
        });

    }


}


class MyCellRender implements ListCellRenderer<String> {
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel iternalPanel = new JPanel(new GridLayout(1, 2));
        JLabel label = new JLabel(String.format("Индекс элемента: %d", index));
        iternalPanel.add(label, 0);
        JLabel label1 = new JLabel(String.format("Значение элемента: %s", value));
        iternalPanel.add(label1, 1);
        if (isSelected) {
            iternalPanel.setBackground(Color.GRAY);
        }

        return iternalPanel;
    }
}

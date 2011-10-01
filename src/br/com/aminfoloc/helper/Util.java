package br.com.aminfoloc.helper;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Util {

    /**
     * Limpa todos os campos que estiverem em um container.
     * @param container JPanel ou qualquer outro container.
     */
    public static void limpar(Container container) {
        for (Component c : container.getComponents()) {
            if ((c instanceof JTextField) || (c instanceof JFormattedTextField)) {
                ((JTextField) c).setText("");
            } else if (c instanceof JScrollPane) {
                try {
                    ((JTextArea) ((JScrollPane) c).getViewport().getComponent(0)).setText("");
                } catch (ClassCastException e) {
                }
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof JList) {
                ((JList) c).setSelectedIndex(0);
            } else if (c instanceof JSpinner) {
                ((JSpinner) c).setValue(new Integer(0));
            } else if (c instanceof JPanel) {
                limpar((JPanel) c);
            }
        }
    }

    /**
     * Ativa ou destiva os componentes de um container.
     * @param container JPanel ou qualquer outro container.
     * @param ativo true ou false
     */
    private static void ativarComponentes(Container container, boolean ativo) {
        for (Component c : container.getComponents()) {
            if ((c instanceof JTextField) || (c instanceof JFormattedTextField)) {
                ((JTextField) c).setEditable(ativo);
            } else if (c instanceof JScrollPane) {
                try {
                    ((JTextArea) ((JScrollPane) c).getViewport().getComponent(0)).setEditable(ativo);
                } catch (ClassCastException e) {
                }
            } else if (c instanceof JTable) {
                try {
                    ((JTable) ((JScrollPane) c).getViewport().getComponent(0)).setEnabled(ativo);
                } catch (ClassCastException e) {
                }
            } else if (c instanceof JCheckBox) {
                ((JCheckBox) c).setEnabled(ativo);
            } else if (c instanceof JComboBox) {
                ((JComboBox) c).setEnabled(ativo);
            } else if (c instanceof JList) {
                ((JList) c).setEnabled(ativo);
            } else if (c instanceof JButton) {
                ((JButton) c).setEnabled(ativo);
            } else if (c instanceof JSpinner) {
                ((JSpinner) c).setEnabled(ativo);
            } else if (c instanceof JPanel) {
                ativarComponentes((JPanel) c, ativo);
            } else if (c instanceof JTabbedPane) {
                ativarComponentes((JTabbedPane) c, ativo);
            }
        }
    }

    public static void ativar(Container container) {
        ativarComponentes(container, true);
    }

    public static void desativar(Container container) {
        ativarComponentes(container, false);
    }
}

import com.walkerhildebrand.main.Question;
import com.walkerhildebrand.main.Section;
import com.walkerhildebrand.main.Subsection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JPanel rootPanel;
    private JList subsectionJList;
    private JList sectionJList;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton leftButton;
    private JButton rightButton;
    private JLabel chapterLabel;
    private JLabel resultsJLabel;
    private JTextArea textArea1;

    private Section[] chapters;
    private int questionIndex;


    private void initComponents() {

        // Answer Buttons
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code when a button is clicked
                System.out.println(e.getActionCommand());
            }
        };

        aButton.addActionListener(buttonListener);
        bButton.addActionListener(buttonListener);
        cButton.addActionListener(buttonListener);
        dButton.addActionListener(buttonListener);
        eButton.addActionListener(buttonListener);


        // Section List



    }

    // Sets the chapter label to be the name of the section that is selected
    private void updateChapterLabel() {
        chapterLabel.setText(chapters[sectionJList.getSelectedIndex()].getName());
    }




    //
    private void updateSections() {
        String[] sectionStrings = new String[chapters.length];

        for (int i = 0; i < sectionStrings.length; i++) {
            sectionStrings[i] = chapters[i].getName();
        }


        sectionJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = sectionStrings;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });

        sectionJList.setSelectedIndex(0);
        updateSubsections();
    }

    //
    private void updateSubsections() {
        questionIndex = 0;

        Subsection[] subsections = chapters[sectionJList.getSelectedIndex()].getSubsections();
        String[] subsectionStrings = new String[subsections.length];

        for (int i = 0; i < subsectionStrings.length; i++) {
            subsectionStrings[i] = subsections[i].getName();
        }

        subsectionJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = subsectionStrings;
            @Override
            public int getSize() {return strings.length;}
            @Override
            public String getElementAt(int i) {return strings[i];}
        });

        subsectionJList.setSelectedIndex(0);
        updateQuestion();
        updateButtons();
    }

    //
    private void updateButtons() {
        resultsJLabel.setText("");


    }

    //
    private void clearResults() {

    }

    //
    private void updateQuestion() {

    }

    //
    private Question[] getCurrentQuestions () {
        return null;
    }

    //
    private void setMnemonics() {

    }

    //
    public MainGUI () {





    }
}

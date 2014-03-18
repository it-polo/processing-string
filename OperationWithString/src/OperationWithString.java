import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;


class AddFrame extends OperationWithString
{
	private static String ENTER = "Enter";
    static JButton enterButton;
    public static JTextArea output;
    public static JTextField input;
    public static JComboBox editComboBox;
    public static JComboBox editComboBoxS;
    static JFrame frame;
    static JPanel panel;
    public static String[] itemsLeng = {
    	"English",
    	"�������"
    	};
    public static String[] itemsSound = {
	    "vowels",
	    "consonants",
	    "�������",
	    "���������"
	};

	public static void createFrame()
    {
        frame = new JFrame("OperationWithString");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        ButtonListener buttonListener = new ButtonListener();
        output = new JTextArea(30, 100);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        JScrollPane scroller = new JScrollPane(output);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel inputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
        input = new JTextField(20);
        enterButton = new JButton("Enter");
        enterButton.setActionCommand(ENTER);
        enterButton.addActionListener(buttonListener);
        // enterButton.setEnabled(false);
        input.setActionCommand(ENTER);
        input.addActionListener(buttonListener);
        DefaultCaret caret = (DefaultCaret) output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panel.add(scroller);
        inputpanel.add(input);
        inputpanel.add(enterButton);
        panel.add(inputpanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        // Center of screen
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        input.requestFocus();
        output.setFont(new Font( "Dialog", Font.ITALIC, 15 ));
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        editComboBox = new JComboBox(itemsLeng);
        editComboBox.setVisible(true);
        inputpanel.add(editComboBox);
        editComboBoxS = new JComboBox(itemsSound);
        editComboBoxS.setVisible(true);
        inputpanel.add(editComboBoxS);
    }
}


class ButtonListener extends AddFrame implements ActionListener
{
	public static void findVowelsInEnglishString(){
		String str = input.getText();
    	char[] temp = str.toCharArray();
        int countVow = 0;
        char[] strVow = {'a','A','e','E','i','I','o','O','u','U'};
        
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < strVow.length; j++) {
	            if(temp[i] == strVow[j]){
	            	countVow++;
	            }
            }
        }
        output.append("\n Length of the string with spaces equal: " + str.length() + "\n" + "Number of vowels in a string is:  " 
	            + countVow +"\n");
	}
	public static void findConsonantsInEnglishString(){
		String str = input.getText();
		char[] temp = str.toCharArray();
		int countCon = 0;
        char[] strCon = {'b','B','c','C','d','D','f','F','g','G','h','H','j','J','k','K','l','L',
        		'm','M','n','N','p','P','q','Q','r','R','s','S','t','T','v','V','x','X','y','Y','z','Z'};
        
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < strCon.length; j++) {
	            if(temp[i] == strCon[j]){
	            	countCon++;
	            }
            }
        }
        output.append("\n Length of the string with spaces equal: " + str.length() + "\n" + "Number of consonants in a string is: " + countCon +"\n");
	}
	public static void findVowelsInRussianString(){
		String str = input.getText();
    	char[] temp = str.toCharArray();
        int countVow = 0;
        char[] strVow = {'�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'};
        
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < strVow.length; j++) {
	            if(temp[i] == strVow[j]){
	            	countVow++;
	            }
            }
        }
        output.append("\n ����� ������ � ������ �������� �����: " + str.length() + "\n" + "���������� ������� ���� � ������ �����:  " 
	            + countVow +"\n");
	}
	public static void findConsonantsInRussianString(){
		String str = input.getText();
    	char[] temp = str.toCharArray();
		int countCon = 0;
        char[] strCon = {'�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'};
        
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < strCon.length; j++) {
	            if(temp[i] == strCon[j]){
	            	countCon++;
	            }
            }
        }
        output.append("\n ����� ������ � ������ �������� �����: " + str.length() + "\n" + "���������� ��������� ���� � ������ �����: " + countCon +"\n");
	}
	public static void selectedItem()
	{
		Object str1 = (String)editComboBox.getSelectedItem();
		Object str2 = (String)editComboBoxS.getSelectedItem();
    	if (str1.equals("English") && str2.equals("vowels"))
    	{
    		findVowelsInEnglishString();
    	}
    	if (str1.equals("English") && str2.equals("consonants"))
    	{
    		findConsonantsInEnglishString();
    	}
    	if (str1.equals("�������") && str2.equals("�������"))
    	{
    		findVowelsInRussianString();
    	}
    	if (str1.equals("�������") && str2.equals("���������"))
    	{
    		findConsonantsInRussianString();
    	}
	}
    public void actionPerformed(final ActionEvent ev)
    {
    	selectedItem();
    }
}



public class OperationWithString {
    public static void main(String... args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        AddFrame add = new AddFrame();
        add.createFrame();

    }
}

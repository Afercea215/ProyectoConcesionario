package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

class TextboxTool {
	 
static void setAcceptNumberOnly(JTextField component, int limit) {
 
	DecimalFormat formatter = new DecimalFormat("#,###");
	String str = component.getText();
	 
	component.setDocument((Document) new TextboxTool.JTextDocLimit(limit));
	component.setText(formatter.format(Long.parseLong(str)));
	component.select(component.getText().length(), 0);
	component.addKeyListener((KeyListener) new KeyAdapter() {
	private JTextField obj = component;
	 
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		char c = keyEvent.getKeyChar();
		if (!(Character.isDigit(c))||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE) {
			keyEvent.consume();
		}
	}
	 
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		char c = keyEvent.getKeyChar();
		if (Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE || c==KeyEvent.VK_LEFT || c==KeyEvent.VK_RIGHT) {
			String str = this.obj.getText().replace(",", "");
			 
			if (str.equals("")) {
				str = "0";
			}
			 
			int selstart = this.obj.getSelectionStart();
			int lentoend = this.obj.getText().length() - selstart;
			 
			this.obj.setText(formatter.format(Long.parseLong(str)));
			 
			int newselstart = this.obj.getText().length() - lentoend;
			this.obj.select(newselstart, 0);
		 
		}
	}
	 
	});
}
 
public static class JTextDocLimit extends PlainDocument {
	private int limit;
	 
	JTextDocLimit(int limit) {
		super();
		this.limit = limit;
	}
	 
	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
		return;
		 
		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}
}

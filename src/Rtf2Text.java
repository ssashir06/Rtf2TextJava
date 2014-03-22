import java.io.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.*;

public class Rtf2Text {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		if (args.length != 1) return;

		String filename = args[0];
		InputStreamReader sr;
		try {
			sr = new InputStreamReader(new FileInputStream(filename), "MS932");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}

		RTFEditorKit kit = new RTFEditorKit();
		Document doc = kit.createDefaultDocument();
		
		try {
			kit.read(sr, doc, 0);
		} catch (IOException | BadLocationException e) {
			e.printStackTrace();
			return;
		}

		try {
			System.out.print(doc.getText(0, doc.getLength()));
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
	}
}

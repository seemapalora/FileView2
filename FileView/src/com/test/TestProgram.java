package com.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.File;
import com.model.Folder;
import com.model.HiddenFile;
import com.model.Node;
import com.model.RemoteFolder;

public class TestProgram {

	/*
	 * Factory methods delegate to constructors. We only keep these because they
	 * were in the HTML script, and we had the requirement to leave that code
	 * alone. It could be re-written with "new Folder()" etc.
	 */

	public static Node createFolder(String name) {
		return null;
	}

	public static Node createRemoteFolder(String name) {
		return null;
	}

	public static Node createFile(String name, int size, String lastModified) {
		return null;
	}

	public static Node createHiddenFile(String name, int size, String lastModified) {
		return null;
	}

	public static void main(String[] args) {
		Node root = new Folder("JSCodingAssessment");
		Node CSS = new Folder("CSS");
		Node HTML = new Folder("HTML");
		Node JavaScript1 = new Folder("JavaScript1");
		Node JavaScript2 = new Folder("JavaScript2");

		((Folder) root).add(CSS);
		((Folder) root).add(HTML);
		((Folder) root).add(JavaScript1);
		((Folder) root).add(JavaScript2);

		((Folder) CSS).add(new File("allegro.css", 131, "10/29/17"));
		((Folder) CSS).add(new File("HotCrossBuns.html", 1155, "10/29/17"));

		((Folder) HTML).add(new File("invoice123.html", 144, "10/29/17"));
		((Folder) HTML).add(new File("invoice456.html", 144, "10/29/17"));
		((Folder) HTML).add(new File("invoice789.html", 144, "10/29/17"));
		((Folder) HTML).add(new File("summary.html", 583, "10/29/17"));

		Node jQuery1 = new RemoteFolder("https://ajax.googleapis.com/ajax/libs/jquery/3.2.1");
		Node authors = new File("AUTHORS.txt", 12535, "9/4/16");
		Node jqueryui = new File("jquery-ui.min.js", 253385, "9/4/16");
		Node jquery = new File("jquery.js", 86351, "9/4/16");
		Node license = new File("LICENSE.txt", 1817, "9/4/16");

		((Folder) jQuery1).add(authors);
		((Folder) jQuery1).add(jqueryui);
		((Folder) jQuery1).add(jquery);
		((Folder) jQuery1).add(license);

		((Folder) JavaScript1).add(new File("cart.html", 1526, "10/29/17"));
		((Folder) JavaScript1).add(jQuery1);
		((Folder) JavaScript1).add(new File("redX.png", 3631, "10/29/17"));
		((Folder) JavaScript1).add(new File("Shopping.css", 451, "10/29/17"));
		((Folder) JavaScript1).add(new HiddenFile(".Trashes", 500, "10/30/17"));

		Node jQuery2 = new RemoteFolder("https://ajax.googleapis.com/ajax/libs/jquery/3.2.1");
		((Folder) jQuery2).add(authors);
		((Folder) jQuery2).add(jqueryui);
		((Folder) jQuery2).add(jquery);
		((Folder) jQuery2).add(license);

		((Folder) JavaScript2).add(new File("correctAppearance.png", 77824, "10/30/17"));
		((Folder) JavaScript2).add(new File("folders.css", 166, "10/29/17"));
		((Folder) JavaScript2).add(new File("folders.html", 530, "10/30/17"));
		((Folder) JavaScript2).add(jQuery2);

		System.out.println("<html><body>" + root.asHTML() + "</body></html>");
		try (PrintWriter out = new PrintWriter(new FileWriter("files.html"));) {
			out.print("<html><body>" + root.asHTML() + "</body></html>");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

package com.model;

import static com.utils.FileConstants.BREAK;
import static com.utils.FileConstants.BYTES;
import static com.utils.FileConstants.CLOSE_BRACKET;
import static com.utils.FileConstants.LI;
import static com.utils.FileConstants.LI2;
import static com.utils.FileConstants.OPEN_BRACKET;
import static com.utils.FileConstants.STRONG_END;
import static com.utils.FileConstants.STRONG_START;
import static com.utils.FileConstants.UL;
import static com.utils.FileConstants.UL2;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {
	
	public Folder(String name) {
		super(name);
	}

	protected List<Node> contents = new ArrayList<Node>();

	public List<Node> getContents() {
		return contents;
	}

	public void add(Node content) {
		this.contents.add(content);
	}

	public String asHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRONG_START).append(this.getName()).append(OPEN_BRACKET).
		append(this.getSize()).append(BYTES).append(CLOSE_BRACKET).append(STRONG_END).append(BREAK);
		builder.append(UL);
		for (Node content : contents) {
			builder.append(LI);
			builder.append(content.asHTML());
			builder.append(LI2);
		}
		builder.append(UL2);
		return builder.toString();
	}

	public int getSize() {
        return contents.stream().mapToInt(node->node.getSize()).sum();
	}

}

package com.model;

import static com.utils.FileConstants.BREAK;
import static com.utils.FileConstants.BYTES;
import static com.utils.FileConstants.CLOSE_BRACKET;
import static com.utils.FileConstants.COMMA;
import static com.utils.FileConstants.HIDDEN;
import static com.utils.FileConstants.LAST_MODIFIED_DATE;
import static com.utils.FileConstants.OPEN_BRACKET;
import static com.utils.FileConstants.P_CLOSE;
import static com.utils.FileConstants.P_STYLE_PADDING_LEFT_60PX_STRONG_HIDDEN_START;
import static com.utils.FileConstants.SPAN_END;
import static com.utils.FileConstants.STRONG_END;
import static com.utils.FileConstants.STRONG_START;

public class HiddenFile extends File {

	public HiddenFile(String name, int size, String lastModifiedDate) {
		super(name, size, lastModifiedDate);
	}

	@Override
	public String asHTML() {
		StringBuilder builder = new StringBuilder();
		return builder.append(P_STYLE_PADDING_LEFT_60PX_STRONG_HIDDEN_START).append(STRONG_START).
		append(this.getName()).append(STRONG_END).append(OPEN_BRACKET).append(this.getSize()).append(BYTES).append(COMMA).append(LAST_MODIFIED_DATE)
		.append(this.getLastModifiedDate()).append(CLOSE_BRACKET).append(HIDDEN).append(BREAK).append(SPAN_END).append(P_CLOSE).toString();
	}

}

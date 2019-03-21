package com.model;

import static com.utils.FileConstants.BREAK;
import static com.utils.FileConstants.EM_END;
import static com.utils.FileConstants.EM_START;
import static com.utils.FileConstants.P_CLOSE;
import static com.utils.FileConstants.P_STYLE_PADDING_LEFT_60PX_STRONG_START;

public class RemoteFolder extends Folder {
	
	public RemoteFolder(String name) {
		super(name);
	}
	
	@Override
	public int getSize(){
		return 0;
	}
	
	@Override
	public String asHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append(EM_START);
		builder.append(P_STYLE_PADDING_LEFT_60PX_STRONG_START);
		builder.append(super.asHTML());
		builder.append(EM_END).append(P_CLOSE).append(BREAK);
		return builder.toString();
	}

}

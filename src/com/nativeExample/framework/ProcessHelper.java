package com.nativeExample.framework;

import java.io.IOException;

public class ProcessHelper {
	private Process process;

	public void start(String path) throws IOException {
		process = Runtime.getRuntime().exec(path);
	}

	public void stop() {
		process.destroy();
	}

}

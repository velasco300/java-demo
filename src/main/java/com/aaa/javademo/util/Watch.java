package com.aaa.javademo.util;

public class Watch {

	private final String id;
	private boolean running;
	private long startTimeMillis;
	private long totalTimeMillis;
	private String statusMsg = "";

	public Watch() {
		this("");
	}

	public Watch(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public boolean isRunning() {
		return this.running;
	}

	public long getTotalTimeMillis() {
		return this.totalTimeMillis;
	}

	public double getTotalTimeSeconds() {
		return this.totalTimeMillis / 1000.0;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public String logMsg(String msg) {
		return "#" + getId() + "#" + " " + msg;
	}

	public String startSummary() {
		return "start Watch #" + getId() + "#";
	}

	public String finishSummary() {
		return "finish Watch #" + getId() + "# status(" + statusMsg + ") running time (sec)="
				+ getTotalTimeSeconds();
	}

	public void start() throws IllegalStateException {
		if (this.running) {
			throw new IllegalStateException("Can't start Watch: it's already running");
		}
		this.running = true;
		this.startTimeMillis = System.currentTimeMillis();
	}

	public void stop() throws IllegalStateException {
		if (!this.running) {
			throw new IllegalStateException("Can't stop Watch: it's not running");
		}
		long lastTime = System.currentTimeMillis() - this.startTimeMillis;
		this.totalTimeMillis += lastTime;
		this.running = false;
	}

}

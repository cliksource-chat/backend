package com.collabera.models;

public class WebSocketChatMessage {
	@Override
	public String toString() {
		return "WebSocketChatMessage [type=" + type + ", message=" + message + ", sender=" + sender + ", chatRoom="
				+ chatRoom + "]";
	}

	private String type;
	private String message;
	private String sender; //user id
	private String chatRoom; //chatRoom id
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String content) {
		this.message = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getChatRoom() {
		return this.chatRoom;
	}
	
	public void setChatRoom(String id) {
		this.chatRoom = id;
	}
}

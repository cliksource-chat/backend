package com.collabera.models;

public class WebSocketChatMessage {
	private String type;
	private String content;
	private String senderId; //user id
	private String chatRoomId; //chatRoom id
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return senderId;
	}
	public void setSender(String sender) {
		this.senderId = sender;
	}
	
	public String getChatRoom() {
		return this.chatRoomId;
	}
	
	public void setChatRoom(String id) {
		this.chatRoomId = id;
	}
}

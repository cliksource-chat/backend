package com.collabera.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Mesages")
public class Messages_Archived {
	
		@Id
		@GeneratedValue
		private int Message_Number_Id;
		
		@Column(name="Mongo Id")
		private String Mongo_Id;
		
		@Column(name="Sender")
		private Users sender;
		
		@Column(name="Message")
		private String message;
		
		@Column(name="Chat Rooms")
		private ChatRooms_Archived chatRooms;
		
		@Column(name="TimeStamp")
		private Date timestamp;
		
		
		public Messages_Archived() {}

		public Messages_Archived(Users sender, String message, ChatRooms_Archived chatRooms, Date timestamp, int Message_Number_Id, String Mongo_Id) {
			super();
			this.Mongo_Id = Mongo_Id;
			this.Message_Number_Id = Message_Number_Id;
			this.sender = sender;
			this.message = message;
			this.chatRooms = chatRooms;
			this.timestamp = timestamp;
		}

		public Users getSender() {
			return sender;
		}

		public void setSender(Users sender) {
			this.sender = sender;
		}

		public ChatRooms_Archived getChatRooms() {
			return chatRooms;
		}

		public void setChatRooms(ChatRooms_Archived chatRooms) {
			this.chatRooms = chatRooms;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		public Date getTimeStamp() {
			return this.timestamp;
		}
		public void setTimeStamp(Date d) {
			this.timestamp = d;
		}

		@Override
		public String toString() {
			return "Messages [id="  + Message_Number_Id + ", sender=" + sender + ", message=" + message + ", chatRooms=" + chatRooms + ", timeStamp=" + timestamp + "]";
		}

		public int getMessage_Number_Id() {
			return Message_Number_Id;
		}

		public void setMessage_Number_Id(int message_Number_Id) {
			Message_Number_Id = message_Number_Id;
		}

		public String getMongoId() {
			return Mongo_Id;
		}

		public void setMongoId(String mongoId) {
			Mongo_Id = mongoId;
		}
		
	}


package com.intel.android.logcommon;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
	public static final int VERBOSE = 2;
	public static final int DEBUG = 3;
	public static final int INFO = 4;
	public static final int WARNING = 5;
	public static final int ERROR = 6;

	private int priority;
	private String tag;
	private String message;
		
	public Message(int priority, String tag, String message) {
		super();
		this.priority = priority;
		this.tag = tag;
		this.message = message;
	}
	
	public Message(Parcel source) {
		this(source.readInt(), source.readString(), source.readString());
	}
	
	@Override
	public String toString() {
		return "Message [priority=" + priority + ", tag=" + tag + ", message="
				+ message + "]";
	}

	//@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(priority);
		dest.writeString(tag);
		dest.writeString(message);
	}
	
	public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {

		//@Override
		public Message createFromParcel(Parcel source) {
			return new Message(source);
		}

		//@Override
		public Message[] newArray(int size) {
			return new Message[size];
		}

	};
	
	//@Override
	public int describeContents() {
		return 0;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

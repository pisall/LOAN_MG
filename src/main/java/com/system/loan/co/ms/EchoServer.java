package com.system.loan.co.ms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoServer {
	private static Set<Session> peer=new HashSet<Session>();
	
	@OnOpen
	public void onOpen(Session session){
		System.out.println(session.getId()+ "has opend a connecttion");
		try{
			peer.add(session);
			session.getBasicRemote().sendText("Conection Established session size="+peer.size());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@OnMessage
	public void onMessage(String message,Session session){
		System.out.println("Message from "+ session.getId() + ": "+message);
		try{
			//session.getBasicRemote().sendText(message);
			System.out.println("start send back");
			session.getBasicRemote().sendText(message);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	@OnClose
	public void onClose(Session session){
		System.out.println("Session "+session.getId()+" has ended");
		System.out.println("session size="+peer.size());
		peer.remove(session);
	}

}

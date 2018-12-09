package com.codygordon.game.settings;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Settings {

	private Document xmlDoc;
	private static Settings instance;
	
	public Settings() {
		loadFile();
	}
	
	public static Settings getInstance() {
		if(instance == null) {
			instance = new Settings();
		}
		return instance;
	}
	
	private void loadFile() {
		try {
			String path = "resources/Settings.xml";
			File xmlFile = new File(path);
			if(!xmlFile.exists()) {
				System.out.println("XML file is null!");
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			xmlDoc = dBuilder.parse(xmlFile);
		}
		catch(Exception e) {
			System.out.println("There was an error parsing the Settings file!");
		}
	}
	
	public String getSetting(String name) {
		if(xmlDoc == null) {
			System.out.println("Failed to load xml file!");
			return null;
		}
		NodeList nodeList = xmlDoc.getElementsByTagName("Setting");
		String value = findSettingWithName(name, nodeList);
		return value;
	}
	
	private String findSettingWithName(String name, NodeList list) {
		for(int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Element element = (Element)node;
			String nameValue = element.getAttribute("name");
			if(name.equals(nameValue)) {
				return element.getTextContent();
			}
		}
		return null;
	}
}